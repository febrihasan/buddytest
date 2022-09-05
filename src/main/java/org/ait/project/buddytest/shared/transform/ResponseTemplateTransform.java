package org.ait.project.buddytest.shared.transform;


import org.ait.project.buddytest.shared.dto.template.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ResponseTemplateTransform {

  @Mapping(target = "responseOutput", source = "body", qualifiedByName = "createDetail")
  ResponseTemplate templateDetail(ResponseSchema responseSchema, Object body);

  @Named("createDetail")
  @Mapping(target = "detail", source = "body")
  ResponseDetail createDetail(Object body);

  @Mapping(target = "responseOutput", source = "body")
  ResponseTemplate templateError(ResponseSchema responseSchema, Object body);

  @Mapping(target = "responseOutput", expression = "java(createResponseList(page,contents))")
  ResponseTemplate templateCollection(ResponseSchema responseSchema, Page page,
                                                           List contents);

  ResponseCollection createResponseCollection(PaginationConfig paginationConfig,
                                              List content);

  @Named("pageCollection")
  @Mapping(target = "page", source = "number")
  @Mapping(target = "size", source = "size")
  @Mapping(target = "total", source = "totalPage")
  PaginationConfig pageCollection(Integer number, Integer size, Long totalPage);

  @Mapping(target = "list", source = "responseCollection")
  ResponseList createResponseListFromCollection(ResponseCollection responseCollection);

  default  ResponseList createResponseList(Page page, List contents) {
    return createResponseListFromCollection(createResponseCollection(
        Optional.ofNullable(page).map(
            pageableData -> pageCollection(page.getNumber(),
                page.getSize(),
                page.getTotalElements())
        ).orElse(null)
        , contents));
  }
}