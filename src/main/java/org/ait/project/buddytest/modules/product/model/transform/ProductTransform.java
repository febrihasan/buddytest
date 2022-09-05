package org.ait.project.buddytest.modules.product.model.transform;

import java.util.List;
import org.ait.project.buddytest.modules.product.dto.request.ProductRequestDto;
import org.ait.project.buddytest.modules.product.dto.response.ProductResponseDto;
import org.ait.project.buddytest.modules.product.model.entity.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**.
 * Class Transform Product
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductTransform {

    Product productDtoToProduct(ProductRequestDto productDto);

    ProductResponseDto productToProductDto(Product product);

    List<ProductResponseDto> productListToProductDtoList(List<Product> products);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product updateProductFromProductDto(
            ProductRequestDto productDto,
            @MappingTarget Product product);
}
