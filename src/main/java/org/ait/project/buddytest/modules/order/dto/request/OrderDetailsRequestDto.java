package org.ait.project.buddytest.modules.order.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class OrderDetailsRequestDto {
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
