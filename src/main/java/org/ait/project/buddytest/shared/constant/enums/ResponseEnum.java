package org.ait.project.buddytest.shared.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseEnum {
  SUCCESS("PMRK-200", "success", HttpStatus.OK),
  CUSTOMER_NOT_FOUND("PMRK-0001", "customer.not.found", HttpStatus.NOT_FOUND),

  INVALID_PARAM("PMRK-0009", "invalid.param", HttpStatus.BAD_REQUEST),
  INTERNAL_SERVER_ERROR("PMRK-9999", "internal.server.error", HttpStatus.INTERNAL_SERVER_ERROR),

  ;

  private String responseCode;
  private String responseMessage;
  private HttpStatus httpStatus;
}
