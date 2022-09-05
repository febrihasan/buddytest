package org.ait.project.buddytest.modules.customer.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CustomerRequestDto {

    @NotBlank(message = "{name.required}")
    @JsonProperty("name")
    private String name;

    @NotBlank(message = "{email.required}")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "{phoneNumber.required}")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @NotBlank(message = "{address.required}")
    @JsonProperty("address")
    private String address;

}
