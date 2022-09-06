package org.ait.project.buddytest.modules.order.service.delegate.impl;

import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.order.exception.JPHNotFoundException;
import org.ait.project.buddytest.modules.order.model.entity.Orders;
import org.ait.project.buddytest.modules.order.model.repository.OrdersRepository;
import org.ait.project.buddytest.modules.order.service.delegate.OrdersDelegate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**.
 * Class Orders Delegate Implements
 */
@Service
@RequiredArgsConstructor
public class OrdersDelegateImpl implements OrdersDelegate {

  private final OrdersRepository repository;

  public List<Orders> getAllOrders() {
    return repository.findAll();
  }

  @Override
  public Page<Orders> getAllOrdersWithPage(final Pageable page) {
    return repository.findAll(page);
  }

  @Override
  public Orders getOrderById(final Long id) {
    return repository.findById(id).orElseThrow(JPHNotFoundException::new);
  }

  @Override
  public void updateTotalAmount(final BigDecimal totalAmount, final Long id) {
    repository.updateTotalAmount(totalAmount, id);
  }

  @Override
  public List<Orders> saveAll(final List<Orders> orders) {
    return repository.saveAll(orders);
  }

  @Override
  public Orders save(final Orders order) {
    return repository.save(order);
  }

  @Override
  public void deleteById(final Long id) {
    repository.deleteById(id);
  }

}
