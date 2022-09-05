package org.ait.project.buddytest.modules.customer.transform;

import org.ait.project.buddytest.modules.customer.dto.CustomerDto;
import org.ait.project.buddytest.modules.customer.model.entity.Customer;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerTransform {
    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);

    List<CustomerDto> customerListToCustomerDtoList(List<Customer> customers);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer updateCustomerFromCustomerDto(CustomerDto customerDto, @MappingTarget Customer customer);
}
