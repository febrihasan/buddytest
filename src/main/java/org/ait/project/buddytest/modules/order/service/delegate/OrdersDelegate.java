package org.ait.project.buddytest.modules.order.service.delegate;

import org.ait.project.buddytest.modules.order.model.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrdersDelegate {

  List<Orders> getAllOrders();

  Page<Orders> getAllOrdersWithPage(Pageable page);

  Orders getOrderById(Long id);

  List<Orders> saveAll(List<Orders> orders);

  Orders save(Orders order);

  void deleteById(Long id);

}
