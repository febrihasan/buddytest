package org.ait.project.buddytest.modules.customer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.customer.common.PathCustomerAPIs;
import org.ait.project.buddytest.modules.customer.dto.CustomerDto;
import org.ait.project.buddytest.modules.customer.model.entity.Customer;
import org.ait.project.buddytest.modules.customer.service.internal.CustomerService;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Get all customers",
            description = "Retrieve a list of all customers")
    @GetMapping(PathCustomerAPIs.FIND_ALL)
    public ResponseEntity<ResponseTemplate<ResponseList<CustomerDto>>> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @Parameter(example = "page 0")
    @Operation(summary = "Get all customers by page",
            description = "Retrieves a list of all customers with pagination")
    @GetMapping(PathCustomerAPIs.FIND_ALL_WITH_PAGE)
    public ResponseEntity<ResponseTemplate<ResponseList<CustomerDto>>> getAllCustomersWithPage(Pageable page) {
        return customerService.getAllCustomersWithPage(page);
    }

    @Operation(summary = "Get customer by id",
            description = "Retrieves a spesific customer by id")
    @GetMapping(PathCustomerAPIs.FIND_ONE)
    public CustomerDto getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @Operation(summary = "Create new customer",
            description = "Create a new customer")
    @PostMapping(PathCustomerAPIs.CREATE)
    public void createCustomer(@RequestBody CustomerDto customerDto) {
        customerService.createCustomer(customerDto);
    }

    @Operation(summary = "Update customer",
            description = "Update a customer")
    @PutMapping(PathCustomerAPIs.UPDATE)
    public CustomerDto updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable Long id) {
        return customerService.updateCustomer(customerDto, id);
    }

    @Operation(summary = "Delete customer",
            description = "Delete a customer")
    @DeleteMapping(PathCustomerAPIs.DELETE)
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

}