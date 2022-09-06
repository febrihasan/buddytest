package org.ait.project.buddytest.modules.inventory.service.internal.impl;

import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.inventory.dto.request.InventoryRequestDto;
import org.ait.project.buddytest.modules.inventory.dto.response.InventoryResponseDto;
import org.ait.project.buddytest.modules.inventory.model.entity.Inventory;
import org.ait.project.buddytest.modules.inventory.model.transform.InventoryTransform;
import org.ait.project.buddytest.modules.inventory.service.delegate.InventoryDelegate;
import org.ait.project.buddytest.modules.inventory.service.internal.InventoryService;
import org.ait.project.buddytest.modules.product.model.entity.Product;
import org.ait.project.buddytest.modules.product.service.delegate.ProductDelegate;
import org.ait.project.buddytest.shared.constant.enums.ResponseEnum;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.ait.project.buddytest.shared.utils.ResponseHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**.
 * class Inventory Service Implements
 */
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    /**.
     * Get function ResponseHelper
     */
    private final ResponseHelper responseHelper;

    /**.
     * Get function InventoryDelegate
     */
    private final InventoryDelegate inventoryDelegate;

    /**.
     * Get function InventoryDelegate
     */
    private final ProductDelegate productDelegate;

    /**.
     * Transform model mapper from entity to DTO or DTO to entity
     */
    private final InventoryTransform inventoryTransform;

    /**.
     * Get all data inventories
     * @return all data inventories
     */
    public ResponseEntity<ResponseTemplate<ResponseList<InventoryResponseDto>>>
    getAllInventories() {
        List<Inventory> inventories = inventoryDelegate
                .getAllInventories();
        return responseHelper
                .createResponseCollection(ResponseEnum.SUCCESS, null,
                inventoryTransform
                        .inventoriesToInventoriesDto(inventories));
    }

    /**.
     * Get all data inventories with page
     * @param page number
     * @return all data inventories with pagination
     */
    public ResponseEntity<ResponseTemplate<ResponseList<InventoryResponseDto>>>
    getAllInventoriesWithPage(final Pageable page) {
        Page<Inventory> inventoriesWithPage = inventoryDelegate
                .getAllInventoriesWithPage(page);
        return responseHelper
                .createResponseCollection(
                        ResponseEnum.SUCCESS,
                        inventoriesWithPage,
                inventoryTransform
                        .inventoriesToInventoriesDto(
                                inventoriesWithPage.getContent()));
    }

    /**.
     * Get a data inventory
     * @param id inventory
     * @return data inventory
     */
    public InventoryResponseDto getInventoryById(final Long id) {
        return inventoryTransform
                .inventoryToInventoryDto(inventoryDelegate.getInventoryById(id));
    }

    /**.
     * Create a new inventory
     * @param inventoryDto
     * @return new data inventory
     */
    public InventoryResponseDto createInventory(final InventoryRequestDto inventoryDto) {
        Inventory inventory = inventoryTransform
                .inventoryDtoToInventory(inventoryDto);
        productDelegate
                .updateStockProduct(Boolean.TRUE, inventory.getProductId());
        return inventoryTransform
                .inventoryToInventoryDto(inventoryDelegate.save(inventory));
    }

    /**.
     * Update data inventory
     * @param id inventory
     * @param inventoryDto payload inventory
     * @return data inventory
     */
    public InventoryResponseDto updateInventory(final InventoryRequestDto inventoryDto,
                                            final Long id) {
        Inventory inventory = inventoryTransform
                .updateInventoryFromInventoryDto(
                        inventoryDto,
                        inventoryDelegate
                                .getInventoryById(id));
        inventory.setId(id);
        if(inventory.getAvailableQuantity() == 0L) {
            productDelegate
                    .updateStockProduct(Boolean.FALSE, inventory.getProductId());
        }
        return inventoryTransform
                .inventoryToInventoryDto(inventoryDelegate.save(inventory));
    }

    /**.
     * Delete a data inventory
     * @param id inventory
     */
    public void deleteInventory(final Long id) {
        Inventory inventory = inventoryDelegate
                .getInventoryById(id);
        productDelegate
                .updateStockProduct(Boolean.FALSE, inventory.getProductId());
        inventoryDelegate
                .deleteById(id);
    }

}
