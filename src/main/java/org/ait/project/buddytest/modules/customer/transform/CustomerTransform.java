package org.ait.project.buddytest.modules.customer.transform;

import org.ait.project.buddytest.modules.customer.dto.request.CustomerRequestDto;
import org.ait.project.buddytest.modules.customer.dto.response.CustomerResponseDto;
import org.ait.project.buddytest.modules.customer.model.entity.Customer;
import org.ait.project.buddytest.shared.openfeign.jsonplaceholder.request.CreateCustomerRequest;
import org.ait.project.buddytest.shared.openfeign.jsonplaceholder.response.CustomerResponse;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring") // for Dependency Injection Spring
public interface CustomerTransform {

  @Named("createJPHCustomerResponse")
  CustomerResponse createJPHCustomerResponse(Customer customer);

  @IterableMapping(qualifiedByName = "createJPHCustomerResponse")
  List<CustomerResponseDto> createJPHCustomerResponseList(
      List<Customer> customerList);

  @Named("createJPHCustomer")
  Customer createJPHCustomer(CustomerResponse customerResponse);

  @IterableMapping(qualifiedByName = "createJPHCustomer")
  List<Customer> createJPHCustomerList(List<CustomerResponse> customerResponseList);

  CreateCustomerRequest createJPHCustomerRequest(CustomerRequestDto customerRequestDto);

  Customer createEntityCustomer(CustomerRequestDto customerRequestDto);

}
