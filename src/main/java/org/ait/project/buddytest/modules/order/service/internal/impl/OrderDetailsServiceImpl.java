package org.ait.project.buddytest.modules.order.service.internal.impl;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.inventory.model.entity.Inventory;
import org.ait.project.buddytest.modules.inventory.service.delegate.InventoryDelegate;
import org.ait.project.buddytest.modules.order.dto.request.OrderDetailsRequestDto;
import org.ait.project.buddytest.modules.order.dto.response.OrderDetailsResponseDto;
import org.ait.project.buddytest.modules.order.dto.response.OrdersResponseDto;
import org.ait.project.buddytest.modules.order.model.entity.OrderDetails;
import org.ait.project.buddytest.modules.order.model.entity.Orders;
import org.ait.project.buddytest.modules.order.model.transform.OrderDetailsTransform;
import org.ait.project.buddytest.modules.order.service.delegate.OrderDetailsDelegate;
import org.ait.project.buddytest.modules.order.service.delegate.OrdersDelegate;
import org.ait.project.buddytest.modules.order.service.internal.OrderDetailsService;
import org.ait.project.buddytest.modules.product.service.delegate.ProductDelegate;
import org.ait.project.buddytest.shared.constant.enums.ResponseEnum;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.ait.project.buddytest.shared.utils.ResponseHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**.
 * class Order Details Service Implements
 */
@Service
@RequiredArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailsService {

    private static final Logger LOGGER = LogManager.getLogger(OrderDetailsServiceImpl.class);
    /**.
     * Get function OrdersHelper
     */
    private final ResponseHelper responseHelper;

    /**.
     * Get function OrderDelegate
     */
    private final OrdersDelegate ordersDelegate;

    /**.
     * Get function OrderDetailsDelegate
     */
    private final OrderDetailsDelegate orderDetailsDelegate;

    /**.
     * Get function InventoryDelegate
     */
    private final InventoryDelegate inventoryDelegate;

    /**.
     * Get function ProductDelegate
     */
    private final ProductDelegate productDelegate;

    /**.
     * Transform model mapper from entity to DTO or DTO to entity
     */
    private final OrderDetailsTransform orderDetailsTransform;

    /**.
     * Get all data order details
     * @param orderId
     * @return all data order details
     */
    public ResponseEntity<ResponseTemplate<ResponseList<OrderDetailsResponseDto>>>
    getAllOrderDetails(final Long orderId) {
        List<OrderDetails> orderDetails = orderDetailsDelegate.getAllOrderDetails(orderId);
        return responseHelper
                .createResponseCollection(ResponseEnum.SUCCESS, null,
                        orderDetailsTransform.orderDetailsToOrderDetailsDto(orderDetails));
    }

    /**.
     * Get a data order detail
     * @param orderId
     * @param id
     * @return data order detail
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<OrderDetailsResponseDto>>>
    getOrderDetailById(final Long orderId, final Long id) {
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        orderDetailsTransform
                                .orderDetailsToOrderDetailsDto(orderDetailsDelegate
                                        .getOrderDetailById(id)));
    }

    /**.
     * Create a new order detail
     * @param orderDetailsDto
     * @param orderId
     * @return new data order detail
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<OrderDetailsResponseDto>>>
    createOrderDetail(final OrderDetailsRequestDto orderDetailsDto,
                                  final Long orderId) {
        OrderDetails orderDetail = orderDetailsTransform
                .orderDetailsDtoToOrderDetails(orderDetailsDto);
        orderDetail.setOrderId(orderId);

        updateQuantity(orderDetail);

        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        orderDetailsTransform
                                .orderDetailsToOrderDetailsDto(orderDetailsDelegate.save(orderDetail)));
    }

    /**.
     * Update data order detail
     * @param orderDetailDto
     * @param orderId
     * @param id
     * @return data order detail
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<OrderDetailsResponseDto>>>
    updateOrderDetail(final OrderDetailsRequestDto orderDetailDto,
                                                     final Long orderId, final Long id) {

        OrderDetails detail = orderDetailsDelegate.getOrderDetailById(id);
        Orders order = ordersDelegate.getOrderById(detail.getOrderId());
        Inventory inventory = inventoryDelegate.getInventoryByProductId(detail.getProductId());

        /*
         * Calculating quantity
         */
        long quantity = inventory.getAvailableQuantity();
        if (quantity == 0) {
            productDelegate.updateStockProduct(Boolean.TRUE, detail.getProductId());
        }
        long remaining = quantity + detail.getQuantity();
        inventoryDelegate.updateQuantity(remaining, detail.getProductId());

        OrderDetails orderDetail = orderDetailsTransform
                .updateOrderDetailsFromOrderDetailsDto(
                        orderDetailDto,
                        orderDetailsDelegate.getOrderDetailById(id));
        orderDetail.setId(id);

        updateQuantity(orderDetail);

        LOGGER.info(" before: total amount {}", order.getAmount());
        LOGGER.info(" before: detail amount {}", detail.getAmount());
        BigDecimal remainAmount = order.getAmount().subtract(detail.getAmount());
        LOGGER.info(" after: remain amount {}", remainAmount);
        BigDecimal totalAmount = remainAmount.add(orderDetail.getAmount());
        LOGGER.info(" after: total amount {}", totalAmount);

        ordersDelegate.updateTotalAmount(totalAmount, order.getId());

        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        orderDetailsTransform
                                .orderDetailsToOrderDetailsDto(orderDetailsDelegate.save(orderDetail)));
    }

    /**.
     * Delete a data order detail
     * @param orderId
     * @param id
     */
    public void deleteOrderDetail(final Long orderId, final Long id) {
        orderDetailsDelegate.deleteById(id);
    }

    private void updateQuantity(final OrderDetails orderDetail) {
        Inventory inventory = inventoryDelegate.getInventoryByProductId(orderDetail.getProductId());
        long quantity = inventory.getAvailableQuantity();
        if (quantity > 0) {
            long remaining = quantity - orderDetail.getQuantity();
            inventoryDelegate.updateQuantity(remaining, orderDetail.getProductId());
        } else {
            productDelegate.updateStockProduct(Boolean.FALSE, orderDetail.getProductId());
        }
    }

}
