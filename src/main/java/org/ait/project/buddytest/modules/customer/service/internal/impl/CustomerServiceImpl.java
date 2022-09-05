package org.ait.project.buddytest.modules.customer.service.internal.impl;

import org.ait.project.buddytest.modules.customer.dto.response.CustomerResponseDto;
import org.ait.project.buddytest.modules.customer.model.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.customer.service.delegate.CustomerDelegate;
import org.ait.project.buddytest.modules.customer.service.internal.CustomerService;
import org.ait.project.buddytest.modules.customer.transform.CustomerTransform;
import org.ait.project.buddytest.shared.constant.enums.ResponseEnum;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.ait.project.buddytest.shared.openfeign.jsonplaceholder.JsonPlaceHolderClient;
import org.ait.project.buddytest.shared.openfeign.jsonplaceholder.response.CustomerResponse;
import org.ait.project.buddytest.shared.utils.ResponseHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final ResponseHelper responseHelper;

  private final JsonPlaceHolderClient client;

  private final CustomerDelegate customerDelegate;

  private final CustomerTransform customerTransform;


  public ResponseEntity<ResponseTemplate<ResponseList<CustomerResponseDto>>> getAllCustomers() {

    List<Customer> customerList = customerDelegate.getAllCustomers();

    if (customerList.isEmpty()) {
      List<CustomerResponse> customerResponseList = client.getListCustomer();
      if (!customerResponseList.isEmpty()) {
        customerList = customerDelegate.saveAll(customerTransform.createJPHCustomerList(customerResponseList));
      }
    }

    return responseHelper.createResponseCollection(ResponseEnum.SUCCESS, null,
        customerTransform.createJPHCustomerResponseList(customerList));
  }

}
