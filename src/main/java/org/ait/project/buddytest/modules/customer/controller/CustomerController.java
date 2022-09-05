package org.ait.project.buddytest.modules.customer.controller;

import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.customer.common.PathCustomerAPIs;
import org.ait.project.buddytest.modules.customer.dto.response.CustomerResponseDto;
import org.ait.project.buddytest.modules.customer.service.internal.CustomerService;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomerService {

    private final CustomerService customerService;

    @Override
    @GetMapping(PathCustomerAPIs.base)
    public ResponseEntity<ResponseTemplate<ResponseList<CustomerResponseDto>>> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}
