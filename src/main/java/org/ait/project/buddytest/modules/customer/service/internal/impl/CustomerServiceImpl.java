package org.ait.project.buddytest.modules.customer.service.internal.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.customer.dto.request.CustomerRequestDto;
import org.ait.project.buddytest.modules.customer.dto.response.CustomerResponseDto;
import org.ait.project.buddytest.modules.customer.model.entity.Customer;
import org.ait.project.buddytest.modules.customer.model.transform.CustomerTransform;
import org.ait.project.buddytest.modules.customer.service.delegate.CustomerDelegate;
import org.ait.project.buddytest.modules.customer.service.internal.CustomerService;
import org.ait.project.buddytest.shared.constant.enums.ResponseEnum;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.ait.project.buddytest.shared.utils.ResponseHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**.
 * Customer Service Implements
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    /**.
     * Get function ResponseHelper
     */
    private final ResponseHelper responseHelper;

    /**.
     * Get function CustomerDelegate
     */
    private final CustomerDelegate customerDelegate;

    /**.
     * Transform model mapper from entity to DTO or DTO to entity
     */
    private final CustomerTransform customerTransform;

    /**.
     * Get all data customers
     * @return all data customers
     */
    public ResponseEntity<ResponseTemplate<ResponseList<CustomerResponseDto>>>
    getAllCustomers() {
        List<Customer> customers = customerDelegate.getAllCustomers();
        return responseHelper.createResponseCollection(ResponseEnum.SUCCESS, null,
                customerTransform.customerListToCustomerDtoList(customers));
    }

    /**.
     * Get all data customers with page
     * @param page number
     * @return all data customers with pagination
     */
    public ResponseEntity<ResponseTemplate<ResponseList<CustomerResponseDto>>>
    getAllCustomersWithPage(final Pageable page) {
        Page<Customer> customersWithPage = customerDelegate
                .getAllCustomersWithPage(page);
        return responseHelper
                .createResponseCollection(
                        ResponseEnum.SUCCESS,
                        customersWithPage,
                customerTransform
                        .customerListToCustomerDtoList(
                                customersWithPage.getContent()));
    }

    /**.
     * Get a data customer
     * @param id customer
     * @return data customer
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<CustomerResponseDto>>>
    getCustomerById(final Long id) {
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        customerTransform
                                .customerToCustomerDto(customerDelegate.getCustomerById(id)));
    }


    /**.
     * Create a new customer
     * @param customerDto
     * @return new data customer
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<CustomerResponseDto>>>
    createCustomer(final CustomerRequestDto customerDto) {
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        customerTransform
                                .customerToCustomerDto(customerDelegate.save(customerTransform
                                        .customerDtoToCustomer(customerDto))));
    }

    /**.
     * Update data customer
     * @param id customer
     * @param customerDto payload customer
     * @return data customer
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<CustomerResponseDto>>>
    updateCustomer(final CustomerRequestDto customerDto, final Long id) {
        Customer customer = customerTransform.updateCustomerFromCustomerDto(
                customerDto,
                customerDelegate.getCustomerById(id));
        customer.setId(id);
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        customerTransform
                                .customerToCustomerDto(customerDelegate.save(customer)));
    }

    /**.
     * Delete a customer
     * @param id customer
     */
    public void deleteCustomer(final Long id) {
        customerDelegate.deleteById(id);
    }

}
