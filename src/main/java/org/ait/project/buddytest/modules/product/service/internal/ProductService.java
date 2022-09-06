package org.ait.project.buddytest.modules.product.service.internal;

import org.ait.project.buddytest.modules.product.dto.request.ProductRequestDto;
import org.ait.project.buddytest.modules.product.dto.response.ProductResponseDto;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**.
 * Interface Product Service
 */
public interface ProductService {

    public ResponseEntity<ResponseTemplate<ResponseList<ProductResponseDto>>>
    getAllProducts();

    public ResponseEntity<ResponseTemplate<ResponseList<ProductResponseDto>>>
    getAllProductsWithPage(Pageable page);

    public ProductResponseDto getProductById(Long id);

    public ProductResponseDto createProduct(ProductRequestDto productDto);

    public ProductResponseDto updateProduct(ProductRequestDto productDto, Long id);

    public void deleteProduct(Long id);

}
