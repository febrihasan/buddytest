package org.ait.project.buddytest.modules.inventory.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**.
 * Class Inventory Response DTO
 */
@Data
public class InventoryResponseDto {
    @JsonProperty("id")
    private final Long id;
    @JsonProperty("product_id")
    private final Long productId;
    @JsonProperty("available_quantity")
    private final Long availableQuantity;
}
