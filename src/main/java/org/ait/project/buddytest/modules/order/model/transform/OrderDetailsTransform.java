package org.ait.project.buddytest.modules.order.model.transform;

import java.util.List;
import org.ait.project.buddytest.modules.order.dto.request.OrderDetailsRequestDto;
import org.ait.project.buddytest.modules.order.dto.response.OrderDetailsResponseDto;
import org.ait.project.buddytest.modules.order.model.entity.OrderDetails;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderDetailsTransform {
    OrderDetails orderDetailsDtoToOrderDetails(OrderDetailsRequestDto orderDetailsDto);

    OrderDetailsResponseDto orderDetailsToOrderDetailsDto(OrderDetails orderDetails);

    List<OrderDetailsResponseDto> orderDetailsToOrderDetailsDto(List<OrderDetails> orderDetails);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderDetails updateOrderDetailsFromOrderDetailsDto(OrderDetailsRequestDto orderDetailsDto, @MappingTarget OrderDetails orderDetails);
}
