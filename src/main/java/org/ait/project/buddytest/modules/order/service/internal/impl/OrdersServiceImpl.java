package org.ait.project.buddytest.modules.order.service.internal.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.order.dto.request.OrdersRequestDto;
import org.ait.project.buddytest.modules.order.dto.response.OrdersResponseDto;
import org.ait.project.buddytest.modules.order.model.entity.Orders;
import org.ait.project.buddytest.modules.order.model.transform.OrderDetailsTransform;
import org.ait.project.buddytest.modules.order.model.transform.OrdersTransform;
import org.ait.project.buddytest.modules.order.service.delegate.OrderDetailsDelegate;
import org.ait.project.buddytest.modules.order.service.delegate.OrdersDelegate;
import org.ait.project.buddytest.modules.order.service.internal.OrderDetailsService;
import org.ait.project.buddytest.modules.order.service.internal.OrdersService;
import org.ait.project.buddytest.shared.constant.enums.ResponseEnum;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.ait.project.buddytest.shared.utils.ResponseHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
     * Get function OrderDetailsService
     */
    private final OrderDetailsService orderDetailsService;

    /**.
     * Transform model mapper from entity to DTO or DTO to entity
     */
    private final OrdersTransform ordersTransform;

    /**.
     * Transform model mapper from entity to DTO or DTO to entity
     */
    private final OrderDetailsTransform orderDetailsTransform;

    /**.
     * Get all data orders
     * @return all data orders
     */
    public ResponseEntity<ResponseTemplate<ResponseList<OrdersResponseDto>>>
    getAllOrders() {
        List<Orders> orders = ordersDelegate.getAllOrders();
        List<OrdersResponseDto> ordersDto = ordersTransform.ordersToOrdersDto(orders);
        ordersDto.forEach(order ->
            order.setOrderDetails(orderDetailsTransform
                    .orderDetailsToOrderDetailsDto(orderDetailsDelegate
                            .getAllOrderDetails(order.getId()))));
        return responseHelper
                .createResponseCollection(ResponseEnum.SUCCESS, null, ordersDto);
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
     * @param id
     * @return data order
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<OrdersResponseDto>>>
    getOrderById(final Long id) {
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        ordersTransform
                                .orderToOrderDto(ordersDelegate.getOrderById(id)));
    }

    /**.
     * Create a new order
     * @param ordersDto
     * @return new data order
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<OrdersResponseDto>>>
    createOrder(final OrdersRequestDto ordersDto) {
        Orders orders = ordersTransform.ordersDtoToOrders(ordersDto);
        Orders order = ordersDelegate.save(orders);
        ordersDto.getOrderDetails()
                .forEach(orderDetailsDto ->
                    orderDetailsService
                        .createOrderDetail(orderDetailsDto, order.getId()));

        OrdersResponseDto ordersResponseDto = ordersTransform.orderToOrderDto(orders);
        ordersResponseDto.setOrderDetails(orderDetailsTransform
                .orderDetailsToOrderDetailsDto(orderDetailsDelegate
                        .getAllOrderDetails(ordersResponseDto.getId())));
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS, ordersResponseDto);
    }

    /**.
     * Update data order
     * @param id
     * @param orderDto
     * @return data order
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<OrdersResponseDto>>>
    updateOrder(final OrdersRequestDto orderDto,
                                            final Long id) {
        Orders order = ordersTransform
                .updateOrdersFromOrdersDto(
                        orderDto,
                        ordersDelegate.getOrderById(id));
        order.setId(id);
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        ordersTransform
                                .orderToOrderDto(ordersDelegate.save(order)));
    }

    /**.
     * Delete a data order
     * @param id order
     */
    public void deleteOrder(final Long id) {
        ordersDelegate.deleteById(id);
    }

}
