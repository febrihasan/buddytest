package org.ait.project.buddytest.modules.order.service.internal;

import org.ait.project.buddytest.modules.order.dto.request.OrderDetailsRequestDto;
import org.ait.project.buddytest.modules.order.dto.response.OrderDetailsResponseDto;

/**.
 * Interface Order Details Service
 */
public interface OrderDetailsService {

    public OrderDetailsResponseDto getOrderDetailById(Long id);

    public void createOrderDetail(OrderDetailsRequestDto orderDetailDto);

    public OrderDetailsResponseDto updateOrderDetail(
            OrderDetailsRequestDto orderDetailDto, Long id);

    public void deleteOrderDetail(Long id);

}
