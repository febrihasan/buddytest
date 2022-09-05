package org.ait.project.buddytest.modules.customer.service.delegate.impl;

import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.customer.exception.JPHNotFoundException;
import org.ait.project.buddytest.modules.customer.model.entity.Customer;
import org.ait.project.buddytest.modules.customer.model.repository.CustomerRepository;
import org.ait.project.buddytest.modules.customer.service.delegate.CustomerDelegate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerDelegateImpl implements CustomerDelegate {

  private final CustomerRepository repository;

  public List<Customer> getAllCustomers() {
    return repository.findAll();
  }

  @Override
  public Page<Customer> getAllCustomersWithPage(Pageable page) {
    return repository.findAll(page);
  }

  @Override
  public Customer getCustomerById(Long id) {
    return repository.findById(id).orElseThrow(JPHNotFoundException::new);
  }

  @Override
  public List<Customer> saveAll(List<Customer> customerList) {
    return repository.saveAll(customerList);
  }

  @Override
  public Customer save(Customer customer) {
    return repository.save(customer);
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

}