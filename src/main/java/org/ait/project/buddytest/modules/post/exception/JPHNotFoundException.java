package org.ait.project.buddytest.modules.post.exception;

import lombok.extern.slf4j.Slf4j;
import org.ait.project.buddytest.config.exception.ModuleException;
import org.ait.project.buddytest.shared.constant.enums.ResponseEnum;

@Slf4j
public class JPHNotFoundException extends ModuleException {

  public JPHNotFoundException() {
    super(ResponseEnum.JSON_PLACE_HOLDER_CUSTOMER_NOT_FOUND);
    log.error("JsonPlaceHolder Post not found");
  }
}
