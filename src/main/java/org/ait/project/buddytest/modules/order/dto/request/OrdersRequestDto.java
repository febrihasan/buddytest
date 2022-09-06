package org.ait.project.buddytest.modules.order.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.Data;

/**.
 * Class Order Request DTO
 */
@Data
public class OrdersRequestDto {
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
    private final List<OrderDetailsDto> orderDetails;

    /**.
     * Class Order Detail DTO
     */
    @Data
    public static class OrderDetailsDto {
        @JsonProperty("id")
        private final Long id;
        @JsonProperty("amount")
        private final BigDecimal amount;
        @JsonProperty("price")
        private final BigDecimal price;
        @JsonProperty("quantity")
        private final Long quantity;
        @JsonProperty("product_id")
        private final Long productId;
    }
}
