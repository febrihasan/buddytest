package org.ait.project.buddytest.modules.customer.service.internal.impl;

import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.customer.dto.CustomerDto;
import org.ait.project.buddytest.modules.customer.transform.CustomerTransform;
import org.ait.project.buddytest.modules.customer.model.entity.Customer;
import org.ait.project.buddytest.modules.customer.service.delegate.CustomerDelegate;
import org.ait.project.buddytest.modules.customer.service.internal.CustomerService;
import org.ait.project.buddytest.shared.constant.enums.ResponseEnum;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.ait.project.buddytest.shared.utils.ResponseHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final ResponseHelper responseHelper;
    private final CustomerDelegate customerDelegate;

    private final CustomerTransform customerTransform;

    public ResponseEntity<ResponseTemplate<ResponseList<CustomerDto>>> getAllCustomers() {
        List<Customer> customers = customerDelegate.getAllCustomers();
        return responseHelper.createResponseCollection(ResponseEnum.SUCCESS, null,
                customerTransform.customerListToCustomerDtoList(customers));
    }

    public ResponseEntity<ResponseTemplate<ResponseList<CustomerDto>>> getAllCustomersWithPage(Pageable page) {
        Page<Customer> customersWithPage = customerDelegate.getAllCustomersWithPage(page);
        return responseHelper.createResponseCollection(ResponseEnum.SUCCESS, customersWithPage,
                customerTransform.customerListToCustomerDtoList(customersWithPage.getContent()));
    }

    public CustomerDto getCustomerById(Long id) {
        return customerTransform.customerToCustomerDto(customerDelegate.getCustomerById(id));
    }

    public void createCustomer(CustomerDto customerDto) {
        Customer customer = customerTransform.customerDtoToCustomer(customerDto);
        customerTransform.customerToCustomerDto(customerDelegate.save(customer));
    }

    public CustomerDto updateCustomer(CustomerDto customerDto, Long id) {
        Customer customer = customerTransform.updateCustomerFromCustomerDto(customerDto, customerDelegate.getCustomerById(id));
        customer.setId(id);
        return customerTransform.customerToCustomerDto(customerDelegate.save(customer));
    }

    public void deleteCustomer(Long id) {
        customerDelegate.deleteById(id);
    }

}
