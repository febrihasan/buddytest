package org.ait.project.buddytest.modules.order.service.internal.impl;

import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.order.dto.request.OrderDetailsRequestDto;
import org.ait.project.buddytest.modules.order.dto.response.OrderDetailsResponseDto;
import org.ait.project.buddytest.modules.order.model.entity.OrderDetails;
import org.ait.project.buddytest.modules.order.model.transform.OrderDetailsTransform;
import org.ait.project.buddytest.modules.order.service.delegate.OrderDetailsDelegate;
import org.ait.project.buddytest.modules.order.service.internal.OrderDetailsService;
import org.ait.project.buddytest.shared.utils.ResponseHelper;
import org.springframework.stereotype.Service;

/**.
 * class Order Details Service Implements
 */
@Service
@RequiredArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailsService {

    /**.
     * Get function OrdersHelper
     */
    private final ResponseHelper responseHelper;

    /**.
     * Get function OrderDetailsDelegate
     */
    private final OrderDetailsDelegate orderDetailsDelegate;

    /**.
     * Transform model mapper from entity to DTO or DTO to entity
     */
    private final OrderDetailsTransform orderDetailsTransform;

    /**.
     * Get a data order detail
     * @param id order detail
     * @return data order detail
     */
    public OrderDetailsResponseDto getOrderDetailById(final Long id) {
        return orderDetailsTransform
                .orderDetailsToOrderDetailsDto(orderDetailsDelegate
                        .getOrderDetailById(id));
    }

    /**.
     * Create a new order detail
     * @param orderDetailsDto
     */
    public void createOrderDetail(final OrderDetailsRequestDto orderDetailsDto) {
        OrderDetails orderDetail = orderDetailsTransform
                .orderDetailsDtoToOrderDetails(orderDetailsDto);
        orderDetailsDelegate.save(orderDetail);
    }

    /**.
     * Update data order detail
     * @param id order detail
     * @param orderDetailDto payload order detail
     * @return data order detail
     */
    public OrderDetailsResponseDto updateOrderDetail(final OrderDetailsRequestDto orderDetailDto,
                                            final Long id) {
        OrderDetails orderDetail = orderDetailsTransform
                .updateOrderDetailsFromOrderDetailsDto(
                        orderDetailDto,
                        orderDetailsDelegate.getOrderDetailById(id));
        orderDetail.setId(id);
        return orderDetailsTransform
                .orderDetailsToOrderDetailsDto(orderDetailsDelegate.save(orderDetail));
    }

    /**.
     * Delete a data order detail
     * @param id order detail
     */
    public void deleteOrderDetail(final Long id) {
        orderDetailsDelegate.deleteById(id);
    }

}
