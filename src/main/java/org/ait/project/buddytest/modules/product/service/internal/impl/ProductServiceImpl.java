package org.ait.project.buddytest.modules.product.service.internal.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.product.dto.request.ProductRequestDto;
import org.ait.project.buddytest.modules.product.dto.response.ProductResponseDto;
import org.ait.project.buddytest.modules.product.model.entity.Product;
import org.ait.project.buddytest.modules.product.model.transform.ProductTransform;
import org.ait.project.buddytest.modules.product.service.delegate.ProductDelegate;
import org.ait.project.buddytest.modules.product.service.internal.ProductService;
import org.ait.project.buddytest.shared.constant.enums.ResponseEnum;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.ait.project.buddytest.shared.utils.ResponseHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**.
 * class Product Service Implements
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    /**.
     * Get function ResponseHelper
     */
    private final ResponseHelper responseHelper;

    /**.
     * Get function ProductDelegate
     */
    private final ProductDelegate productDelegate;

    /**.
     * Transform model mapper from entity to DTO or DTO to entity
     */
    private final ProductTransform productTransform;

    /**.
     * Get all data products
     * @return all data products
     */
    public ResponseEntity<ResponseTemplate<ResponseList<ProductResponseDto>>>
    getAllProducts() {
        List<Product> products = productDelegate
                .getAllProducts();
        return responseHelper
                .createResponseCollection(ResponseEnum.SUCCESS, null,
                productTransform.productListToProductDtoList(products));
    }

    /**.
     * Get all data products with page
     * @param page number
     * @return all data products with pagination
     */
    public ResponseEntity<ResponseTemplate<ResponseList<ProductResponseDto>>>
    getAllProductsWithPage(final Pageable page) {
        Page<Product> productsWithPage = productDelegate
                .getAllProductsWithPage(page);
        return responseHelper
                .createResponseCollection(
                        ResponseEnum.SUCCESS,
                        productsWithPage,
                productTransform
                        .productListToProductDtoList(
                                productsWithPage.getContent()));
    }

    /**.
     * Get a data product
     * @param id product
     * @return data product
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<ProductResponseDto>>>
    getProductById(final Long id) {
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        productTransform
                                .productToProductDto(productDelegate.getProductById(id)));
    }

    /**.
     * Create a new product
     * @param productDto product
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<ProductResponseDto>>>
    createProduct(final ProductRequestDto productDto) {
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        productTransform
                                .productToProductDto(productDelegate.save(productTransform
                                        .productDtoToProduct(productDto))));
    }

    /**.
     * Update data product
     * @param id product
     * @param productDto payload product
     * @return data product
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<ProductResponseDto>>>
    updateProduct(final ProductRequestDto productDto,
                                    final Long id) {
        Product product = productTransform
                .updateProductFromProductDto(
                        productDto,
                        productDelegate.getProductById(id));
        product.setId(id);
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        productTransform
                                .productToProductDto(productDelegate.save(product)));
    }

    /**.
     * Delete a data product
     * @param id product
     */
    public void deleteProduct(final Long id) {
        productDelegate.deleteById(id);
    }

}
