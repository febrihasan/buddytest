package org.ait.project.buddytest.modules.customer.service.delegate.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.customer.exception.JPHNotFoundException;
import org.ait.project.buddytest.modules.customer.model.entity.Customer;
import org.ait.project.buddytest.modules.customer.model.repository.CustomerRepository;
import org.ait.project.buddytest.modules.customer.service.delegate.CustomerDelegate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**.
 * Class Customer Delegate Implements
 */
@Service
@RequiredArgsConstructor
public class CustomerDelegateImpl implements CustomerDelegate {

  private final CustomerRepository repository;

  public List<Customer> getAllCustomers() {
    return repository.findAll();
  }

  @Override
  public Page<Customer> getAllCustomersWithPage(final Pageable page) {
    return repository.findAll(page);
  }

  @Override
  public Customer getCustomerById(final Long id) {
    return repository.findById(id).orElseThrow(JPHNotFoundException::new);
  }

  @Override
  public List<Customer> saveAll(final List<Customer> customerList) {
    return repository.saveAll(customerList);
  }

  @Override
  public Customer save(final Customer customer) {
    return repository.save(customer);
  }

  @Override
  public void deleteById(final Long id) {
    repository.deleteById(id);
  }

}
