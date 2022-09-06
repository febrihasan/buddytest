package org.ait.project.buddytest.modules.order.service.internal.impl;

import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.order.dto.request.OrdersRequestDto;
import org.ait.project.buddytest.modules.order.dto.response.OrdersResponseDto;
import org.ait.project.buddytest.modules.order.model.entity.Orders;
import org.ait.project.buddytest.modules.order.model.transform.OrdersTransform;
import org.ait.project.buddytest.modules.order.service.delegate.OrderDetailsDelegate;
import org.ait.project.buddytest.modules.order.service.delegate.OrdersDelegate;
import org.ait.project.buddytest.modules.order.service.internal.OrdersService;
import org.ait.project.buddytest.shared.constant.enums.ResponseEnum;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.ait.project.buddytest.shared.utils.ResponseHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**.
 * class Orders Service Implements
 */
@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    /**.
     * Get function OrdersHelper
     */
    private final ResponseHelper responseHelper;

    /**.
     * Get function OrdersDelegate
     */
    private final OrdersDelegate ordersDelegate;

    /**.
     * Get function OrderDetailsDelegate
     */
    private final OrderDetailsDelegate orderDetailsDelegate;

    /**.
     * Transform model mapper from entity to DTO or DTO to entity
     */
    private final OrdersTransform ordersTransform;

    /**.
     * Get all data orders
     * @return all data orders
     */
    public ResponseEntity<ResponseTemplate<ResponseList<OrdersResponseDto>>>
    getAllOrders() {
        List<Orders> orders = ordersDelegate
                .getAllOrders();
        return responseHelper
                .createResponseCollection(ResponseEnum.SUCCESS, null,
                ordersTransform.ordersToOrdersDto(orders));
    }

    /**.
     * Get all data orders with page
     * @param page number
     * @return all data orders with pagination
     */
    public ResponseEntity<ResponseTemplate<ResponseList<OrdersResponseDto>>>
    getAllOrdersWithPage(final Pageable page) {
        Page<Orders> ordersWithPage = ordersDelegate
                .getAllOrdersWithPage(page);
        return responseHelper
                .createResponseCollection(
                        ResponseEnum.SUCCESS,
                        ordersWithPage,
                ordersTransform
                        .ordersToOrdersDto(
                                ordersWithPage.getContent()));
    }

    /**.
     * Get a data order
     * @param id order
     * @return data order
     */
    public OrdersResponseDto getOrderById(final Long id) {
        return ordersTransform
                .ordersToOrdersDto(ordersDelegate.getOrderById(id));
    }

    /**.
     * Create a new order
     * @param ordersDto
     */
    public void createOrder(final OrdersRequestDto ordersDto) {
        Orders orders = ordersTransform.ordersDtoToOrders(ordersDto);
        ordersDelegate.save(orders);
    }

    /**.
     * Update data order
     * @param id order
     * @param orderDto payload order
     * @return data order
     */
    public OrdersResponseDto updateOrder(final OrdersRequestDto orderDto,
                                            final Long id) {
        Orders order = ordersTransform
                .updateOrdersFromOrdersDto(
                        orderDto,
                        ordersDelegate.getOrderById(id));
        order.setId(id);
        return ordersTransform
                .ordersToOrdersDto(ordersDelegate.save(order));
    }

    /**.
     * Delete a data order
     * @param id order
     */
    public void deleteOrder(final Long id) {
        ordersDelegate.deleteById(id);
    }

}
