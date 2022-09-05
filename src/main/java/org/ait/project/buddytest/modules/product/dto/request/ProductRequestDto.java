package org.ait.project.buddytest.modules.product.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**.
 * Class Product Request DTO
 */
@Data
public class ProductRequestDto {

    @JsonProperty("id")
    private final Long id;

    @JsonProperty("type")
    private final String type;

    @JsonProperty("seriName")
    private final String seriName;

    @JsonProperty("price")
    private final BigDecimal price;

}
