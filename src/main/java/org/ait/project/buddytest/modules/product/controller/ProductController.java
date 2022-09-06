package org.ait.project.buddytest.modules.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.product.common.PathProductAPIs;
import org.ait.project.buddytest.modules.product.dto.request.ProductRequestDto;
import org.ait.project.buddytest.modules.product.dto.response.ProductResponseDto;
import org.ait.project.buddytest.modules.product.service.internal.ProductService;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**.
 * Class Rest Controller of Product
 */
@RestController
@RequiredArgsConstructor
public class ProductController {

    /**.
     *  Get function Product Service
     */
    private final ProductService productService;

    /**.
     *  Api for Get all products
     */
    @Operation(summary = "Get all products",
            description = "Retrieve a list of all products")
    @GetMapping(PathProductAPIs.FIND_ALL)
    public ResponseEntity<ResponseTemplate<ResponseList<ProductResponseDto>>>
        getAllProducts() {
        return productService.getAllProducts();
    }

    /**.
     *  Api for Get all products with pagination
     * @param page number
     */
    @Operation(summary = "Get all products by page",
            description = "Retrieves a list of all products with pagination")
    @GetMapping(PathProductAPIs.FIND_ALL_WITH_PAGE)
    public ResponseEntity<ResponseTemplate<ResponseList<ProductResponseDto>>>
        getAllProductsWithPage(final Pageable page) {
        return productService.getAllProductsWithPage(page);
    }

    /**.
     *  Api for Get a product
     * @param id
     */
    @Operation(summary = "Get product by id",
            description = "Retrieves a spesific product by id")
    @GetMapping(PathProductAPIs.FIND_ONE)
    public ProductResponseDto getProductById(final @PathVariable Long id) {
        return productService.getProductById(id);
    }

    /**.
     *  Api for Create a new product
     * @param productDto
     */
    @Operation(summary = "Create new product",
            description = "Create a new product")
    @PostMapping(PathProductAPIs.CREATE)
    public ProductResponseDto createProduct(final @RequestBody ProductRequestDto productDto) {
        return productService.createProduct(productDto);
    }

    /**.
     *  Api for Update a product
     * @param id
     * @param productDto
     */
    @Operation(summary = "Update product",
            description = "Update a product")
    @PutMapping(PathProductAPIs.UPDATE)
    public ProductResponseDto updateproduct(final @RequestBody ProductRequestDto productDto,
                                    final @PathVariable Long id) {
        return productService.updateProduct(productDto, id);
    }

    /**.
     *  Api for Delete a product
     * @param id
     */
    @Operation(summary = "Delete product",
            description = "Delete a product")
    @DeleteMapping(PathProductAPIs.DELETE)
    public void deleteProduct(final @PathVariable Long id) {
        productService.deleteProduct(id);
    }

}