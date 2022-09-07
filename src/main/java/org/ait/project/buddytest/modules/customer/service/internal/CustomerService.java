package org.ait.project.buddytest.modules.customer.service.internal;

import org.ait.project.buddytest.modules.customer.dto.request.CustomerRequestDto;
import org.ait.project.buddytest.modules.customer.dto.response.CustomerResponseDto;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**.
 * Interface Customer Service
 */
public interface CustomerService {

    public ResponseEntity<ResponseTemplate<ResponseList<CustomerResponseDto>>>
    getAllCustomers();

    public ResponseEntity<ResponseTemplate<ResponseList<CustomerResponseDto>>>
    getAllCustomersWithPage(Pageable page);

    public ResponseEntity<ResponseTemplate<ResponseDetail<CustomerResponseDto>>>
    getCustomerById(Long id);

    public ResponseEntity<ResponseTemplate<ResponseDetail<CustomerResponseDto>>>
    createCustomer(CustomerRequestDto customerDto);

    public ResponseEntity<ResponseTemplate<ResponseDetail<CustomerResponseDto>>>
    updateCustomer(CustomerRequestDto customerDto, Long id);

    public void deleteCustomer(Long id);

}
