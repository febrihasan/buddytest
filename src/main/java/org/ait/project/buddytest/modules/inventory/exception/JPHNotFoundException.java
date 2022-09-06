package org.ait.project.buddytest.modules.inventory.exception;

import lombok.extern.slf4j.Slf4j;
import org.ait.project.buddytest.config.exception.ModuleException;
import org.ait.project.buddytest.shared.constant.enums.ResponseEnum;

@Slf4j
public class JPHNotFoundException extends ModuleException {

  public JPHNotFoundException() {
    super(ResponseEnum.JSON_PLACE_HOLDER_INVENTORY_NOT_FOUND);
    log.error("Inventory not found");
  }
}
