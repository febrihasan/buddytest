package org.ait.project.buddytest.modules.order.service.internal;

import org.ait.project.buddytest.modules.order.dto.request.OrdersRequestDto;
import org.ait.project.buddytest.modules.order.dto.response.OrdersResponseDto;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**.
 * Interface Product Service
 */
public interface OrdersService {

    public ResponseEntity<ResponseTemplate<ResponseList<OrdersResponseDto>>>
    getAllOrders();

    public ResponseEntity<ResponseTemplate<ResponseList<OrdersResponseDto>>>
    getAllOrdersWithPage(Pageable page);

    public OrdersResponseDto getOrderById(Long id);

    public OrdersResponseDto createOrder(OrdersRequestDto orderDto);

    public OrdersResponseDto updateOrder(OrdersRequestDto orderDto, Long id);

    public void deleteOrder(Long id);

}
