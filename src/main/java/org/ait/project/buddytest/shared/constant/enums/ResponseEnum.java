package org.ait.project.buddytest.shared.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseEnum {
  SUCCESS("PMRK-200", "success", HttpStatus.OK),
  JSON_PLACE_HOLDER_POST_NOT_FOUND("PMRK-0001", "jph.post.not.found", HttpStatus.NOT_FOUND),
  JSON_PLACE_HOLDER_CUSTOMER_NOT_FOUND("PMRK-0002", "jph.customer.not.found", HttpStatus.NOT_FOUND),

  JSON_PLACE_HOLDER_PRODUCT_NOT_FOUND("PMRK-0003", "jph.product.not.found", HttpStatus.NOT_FOUND),
  JSON_PLACE_HOLDER_ORDER_NOT_FOUND("PMRK-0004", "jph.order.not.found", HttpStatus.NOT_FOUND),
  JSON_PLACE_HOLDER_INVENTORY_NOT_FOUND("PMRK-0005", "jph.inventory.not.found", HttpStatus.NOT_FOUND),
  JSON_PLACE_HOLDER_ORDER_DETAIL_NOT_FOUND("PMRK-0006", "jph.order.detail.not.found", HttpStatus.NOT_FOUND),
  INVALID_PARAM("PMRK-0009", "invalid.param", HttpStatus.BAD_REQUEST),
  INTERNAL_SERVER_ERROR("PMRK-9999", "internal.server.error", HttpStatus.INTERNAL_SERVER_ERROR),

  ;

  private String responseCode;
  private String responseMessage;
  private HttpStatus httpStatus;

}
