package org.ait.project.buddytest.modules.customer.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.customer.common.PathCustomerAPIs;
import org.ait.project.buddytest.modules.customer.dto.request.CustomerRequestDto;
import org.ait.project.buddytest.modules.customer.dto.response.CustomerResponseDto;
import org.ait.project.buddytest.modules.customer.service.internal.CustomerService;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**.
 * Class Rest Controller of Customer
 */
@RestController
@RequiredArgsConstructor
public class CustomerController {

    /**.
     *  Get function Customer Service
     */
    private final CustomerService customerService;

    /**.
     *  Api for Get all customers
     */
    @Operation(summary = "Get all customers",
            description = "Retrieve a list of all customers")
    @GetMapping(PathCustomerAPIs.FIND_ALL)
    public ResponseEntity<ResponseTemplate<ResponseList<CustomerResponseDto>>>
        getAllCustomers() {
        return customerService.getAllCustomers();
    }

    /**.
     *  Api for Get all customers with pagination
     * @param page number
     */
    @Operation(summary = "Get all customers with page number",
            description = "Retrieves a list of all customers with pagination")
    @GetMapping(PathCustomerAPIs.FIND_ALL_WITH_PAGE)
    public ResponseEntity<ResponseTemplate<ResponseList<CustomerResponseDto>>>
        getAllCustomersWithPage(final Pageable page) {
        return customerService.getAllCustomersWithPage(page);
    }

    /**.
     *  Api for Get a customer
     * @param id
     */
    @Operation(summary = "Get customer by id",
            description = "Retrieves a spesific customer by id")
    @GetMapping(PathCustomerAPIs.FIND_ONE)
    public ResponseEntity<ResponseTemplate<ResponseDetail<CustomerResponseDto>>>
        getCustomerById(final @PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    /**.
     *  Api for Create a new customer
     * @param customerDto
     */
    @Operation(summary = "Create new customer",
            description = "Create a new customer")
    @PostMapping(PathCustomerAPIs.CREATE)
    public ResponseEntity<ResponseTemplate<ResponseDetail<CustomerResponseDto>>>
        createCustomer(final @RequestBody CustomerRequestDto customerDto) {
        return customerService.createCustomer(customerDto);
    }

    /**.
     *  Api for Update a customer
     * @param id
     * @param customerDto
     */
    @Operation(summary = "Update customer",
            description = "Update a customer")
    @PutMapping(PathCustomerAPIs.UPDATE)
    public ResponseEntity<ResponseTemplate<ResponseDetail<CustomerResponseDto>>>
        updateCustomer(final @RequestBody CustomerRequestDto customerDto,
                                      final @PathVariable Long id) {
        return customerService.updateCustomer(customerDto, id);
    }

    /**.
     *  Api for Delete a customer
     * @param id
     */
    @Operation(summary = "Delete customer",
            description = "Delete a customer")
    @DeleteMapping(PathCustomerAPIs.DELETE)
    public void deleteCustomer(final @PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

}