package org.ait.project.buddytest.modules.order.service.delegate.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.order.exception.JPHNotFoundException;
import org.ait.project.buddytest.modules.order.model.entity.OrderDetails;
import org.ait.project.buddytest.modules.order.model.entity.Orders;
import org.ait.project.buddytest.modules.order.model.repository.OrderDetailsRepository;
import org.ait.project.buddytest.modules.order.service.delegate.OrderDetailsDelegate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**.
 * Class Orders Delegate Implements
 */
@Service
@RequiredArgsConstructor
public class OrderDetailsDelegateImpl implements OrderDetailsDelegate {

  private final OrderDetailsRepository repository;

  @Override
  public OrderDetails getOrderDetailById(final Long id) {
    return repository.findById(id).orElseThrow(JPHNotFoundException::new);
  }

  @Override
  public List<OrderDetails> saveAll(final List<OrderDetails> orderDetails) {
    return repository.saveAll(orderDetails);
  }

  @Override
  public OrderDetails save(final OrderDetails orderDetail) {
    return repository.save(orderDetail);
  }

  @Override
  public void deleteById(final Long id) {
    repository.deleteById(id);
  }

}
