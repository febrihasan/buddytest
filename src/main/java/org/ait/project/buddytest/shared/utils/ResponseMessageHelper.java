package org.ait.project.buddytest.shared.utils;

import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.shared.constant.enums.ResponseEnum;
import org.ait.project.buddytest.shared.dto.template.ResponseSchema;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ResponseMessageHelper {

  private final MessageSource responseMessageSource;

  public ResponseSchema getResponseSchema(ResponseEnum responseEnum) {
    return new ResponseSchema(responseEnum.getResponseCode(),
        getMessage(responseEnum.getResponseMessage()));
  }

  private String getMessage(String code) {
    return responseMessageSource.getMessage(code, null, Locale.getDefault());
  }
}
