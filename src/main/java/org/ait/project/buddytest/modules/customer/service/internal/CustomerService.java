package org.ait.project.buddytest.modules.customer.service.internal;

import org.ait.project.buddytest.modules.customer.dto.response.CustomerResponseDto;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    /**
     * Function used to get All Json Place Holder Customer
     *
     * @return ResponseEntity which contains a list of JsonPlaceHolderCustomer Responses
     */
    ResponseEntity<ResponseTemplate<ResponseList<CustomerResponseDto>>> getAllCustomers();

}
