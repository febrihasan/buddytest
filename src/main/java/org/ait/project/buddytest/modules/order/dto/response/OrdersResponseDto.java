package org.ait.project.buddytest.modules.order.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.Data;

/**.
 * Class Orders Response DTO
 */
@Data
public class OrdersResponseDto {
    @JsonProperty("id")
    private final Long id;
    @JsonProperty("customer_id")
    private final Long customerId;
    @JsonProperty("amount")
    private final BigDecimal amount;
    @JsonProperty("orderDate")
    private final ZonedDateTime orderDate;
    @JsonProperty("orderNumber")
    private final String orderNumber;
    @JsonProperty("orderDetails")
    private List<OrderDetailsResponseDto> orderDetails;
}
