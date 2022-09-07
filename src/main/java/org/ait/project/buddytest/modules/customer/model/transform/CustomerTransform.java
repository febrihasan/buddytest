package org.ait.project.buddytest.modules.customer.model.transform;

import org.ait.project.buddytest.modules.customer.dto.request.CustomerRequestDto;
import org.ait.project.buddytest.modules.customer.dto.response.CustomerResponseDto;
import org.ait.project.buddytest.modules.customer.model.entity.Customer;
import org.mapstruct.*;

import java.util.List;
import java.util.Optional;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerTransform {
    Customer customerDtoToCustomer(CustomerRequestDto customerDto);

    CustomerResponseDto customerToCustomerDto(Customer customer);

    List<CustomerResponseDto> customerListToCustomerDtoList(List<Customer> customers);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer updateCustomerFromCustomerDto(CustomerRequestDto customerDto, @MappingTarget Customer customer);
}
