package org.ait.project.buddytest.modules.customer.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**.
 * Class Customer Response DTO
 */
@Data
public class CustomerResponseDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("address")
    private String address;
}
