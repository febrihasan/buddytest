package org.ait.project.buddytest.modules.order.service.internal;

import org.ait.project.buddytest.modules.order.dto.request.OrdersRequestDto;
import org.ait.project.buddytest.modules.order.dto.response.OrdersResponseDto;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
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

    public ResponseEntity<ResponseTemplate<ResponseDetail<OrdersResponseDto>>>
    getOrderById(Long id);

    public ResponseEntity<ResponseTemplate<ResponseDetail<OrdersResponseDto>>>
    createOrder(OrdersRequestDto orderDto);

    public ResponseEntity<ResponseTemplate<ResponseDetail<OrdersResponseDto>>>
    updateOrder(OrdersRequestDto orderDto, Long id);

    public void deleteOrder(Long id);

}
