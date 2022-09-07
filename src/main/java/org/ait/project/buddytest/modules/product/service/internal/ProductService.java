package org.ait.project.buddytest.modules.product.service.internal;

import org.ait.project.buddytest.modules.product.dto.request.ProductRequestDto;
import org.ait.project.buddytest.modules.product.dto.response.ProductResponseDto;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
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

    public ResponseEntity<ResponseTemplate<ResponseDetail<ProductResponseDto>>>
    getProductById(Long id);

    public ResponseEntity<ResponseTemplate<ResponseDetail<ProductResponseDto>>>
    createProduct(ProductRequestDto productDto);

    public ResponseEntity<ResponseTemplate<ResponseDetail<ProductResponseDto>>>
    updateProduct(ProductRequestDto productDto, Long id);

    public void deleteProduct(Long id);

}
