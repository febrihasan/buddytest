package org.ait.project.buddytest.modules.customer.service.internal;

import org.ait.project.buddytest.modules.customer.dto.CustomerDto;
import org.ait.project.buddytest.modules.customer.model.entity.Customer;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    public ResponseEntity<ResponseTemplate<ResponseList<CustomerDto>>> getAllCustomers();

    public ResponseEntity<ResponseTemplate<ResponseList<CustomerDto>>> getAllCustomersWithPage(Pageable page);

    public CustomerDto getCustomerById(Long id);

    public void createCustomer(CustomerDto customerDto);

    public CustomerDto updateCustomer(CustomerDto customerDto, Long id);

    public void deleteCustomer(Long id);

}
