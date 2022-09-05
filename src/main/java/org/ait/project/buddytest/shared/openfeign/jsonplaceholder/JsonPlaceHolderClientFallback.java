package org.ait.project.buddytest.shared.openfeign.jsonplaceholder;

import org.ait.project.buddytest.shared.openfeign.jsonplaceholder.request.CreateCustomerRequest;
import org.ait.project.buddytest.shared.openfeign.jsonplaceholder.response.CustomerResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JsonPlaceHolderClientFallback implements JsonPlaceHolderClient{

  /**
   * When Openfeign Call failed, then do this
   * */

  @Override
  public List<CustomerResponse> getListCustomer() {
    return null;
  }

  @Override
  public CustomerResponse getCustomerById(String id) {
    return null;
  }

  @Override
  public CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {
    return null;
  }

}
