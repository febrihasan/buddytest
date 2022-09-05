package org.ait.project.buddytest.modules.customer.exception;

import lombok.extern.slf4j.Slf4j;
import org.ait.project.buddytest.config.exception.ModuleException;
import org.ait.project.buddytest.shared.constant.enums.ResponseEnum;

@Slf4j
public class JPHNotFoundException extends ModuleException {

  public JPHNotFoundException() {
    super(ResponseEnum.CUSTOMER_NOT_FOUND);
    log.error("Customer not found");
  }
}
