package org.ait.project.buddytest.modules.order.exception;

import lombok.extern.slf4j.Slf4j;
import org.ait.project.buddytest.config.exception.ModuleException;
import org.ait.project.buddytest.shared.constant.enums.ResponseEnum;

@Slf4j
public class JPHOrderNotFoundException extends ModuleException {

  public JPHOrderNotFoundException() {
    super(ResponseEnum.JSON_PLACE_HOLDER_ORDER_NOT_FOUND);
    log.error("Order not found");
  }
}
