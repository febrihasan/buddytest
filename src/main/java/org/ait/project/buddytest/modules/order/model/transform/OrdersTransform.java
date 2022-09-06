package org.ait.project.buddytest.modules.order.model.transform;

import org.ait.project.buddytest.modules.order.dto.request.OrdersRequestDto;
import org.ait.project.buddytest.modules.order.dto.response.OrdersResponseDto;
import org.ait.project.buddytest.modules.order.model.entity.OrderDetails;
import org.ait.project.buddytest.modules.order.model.entity.Orders;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrdersTransform {
    Orders ordersDtoToOrders(OrdersRequestDto ordersDto);
    OrderDetails orderDetailsDtoToOrderDetails(OrdersRequestDto orderDetailsDto);

    OrdersResponseDto orderToOrderDto(Orders orders);

    List<OrdersResponseDto> ordersToOrdersDto(List<Orders> orders);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Orders updateOrdersFromOrdersDto(OrdersRequestDto ordersDto, @MappingTarget Orders orders);

}
