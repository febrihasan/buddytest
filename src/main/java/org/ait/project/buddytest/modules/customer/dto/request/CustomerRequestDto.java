package org.ait.project.buddytest.modules.customer.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**.
 * Class Customer Request DTO
 */
@Data
public class CustomerRequestDto {
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
