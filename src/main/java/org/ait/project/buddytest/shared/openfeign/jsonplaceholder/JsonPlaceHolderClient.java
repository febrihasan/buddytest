package org.ait.project.buddytest.shared.openfeign.jsonplaceholder;

import org.ait.project.buddytest.shared.openfeign.jsonplaceholder.request.CreateCustomerRequest;
import org.ait.project.buddytest.shared.openfeign.jsonplaceholder.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
    value = "jsonplaceholder-client",
    url = "${restclient.url.jsonplaceholder-client}",
    fallback = JsonPlaceHolderClientFallback.class
)
public interface JsonPlaceHolderClient {

  @GetMapping("/posts")
  List<CustomerResponse> getListCustomer();

  @GetMapping("/posts/{id}")
  CustomerResponse getCustomerById(@PathVariable String id);

  @PostMapping("/posts")
  CustomerResponse createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest);

}
