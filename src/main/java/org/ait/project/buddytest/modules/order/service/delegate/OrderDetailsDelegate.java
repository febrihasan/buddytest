package org.ait.project.buddytest.modules.order.service.delegate;

import org.ait.project.buddytest.modules.order.model.entity.OrderDetails;
import org.ait.project.buddytest.modules.order.model.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderDetailsDelegate {

  OrderDetails getOrderDetailById(Long id);

  List<OrderDetails> saveAll(List<OrderDetails> orderDetails);

  OrderDetails save(OrderDetails orderDetail);

  void deleteById(Long id);

}
