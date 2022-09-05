package org.ait.project.buddytest.modules.customer.service.delegate;

import org.ait.project.buddytest.modules.customer.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerDelegate {

  List<Customer> getAllCustomers();

  Page<Customer> getAllCustomersWithPage(Pageable page);

  Customer getCustomerById(Long id);

  List<Customer> saveAll(List<Customer> customers);

  Customer save(Customer customer);

  void deleteById(Long id);

}
