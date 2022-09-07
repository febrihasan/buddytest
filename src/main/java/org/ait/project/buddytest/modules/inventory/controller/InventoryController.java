package org.ait.project.buddytest.modules.inventory.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.inventory.common.PathInventoryAPIs;
import org.ait.project.buddytest.modules.inventory.dto.request.InventoryRequestDto;
import org.ait.project.buddytest.modules.inventory.dto.response.InventoryResponseDto;
import org.ait.project.buddytest.modules.inventory.service.internal.InventoryService;
import org.ait.project.buddytest.modules.product.common.PathProductAPIs;
import org.ait.project.buddytest.modules.product.dto.request.ProductRequestDto;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**.
 * Class Rest Controller of Inventory
 */
@RestController
@RequiredArgsConstructor
public class InventoryController {

    /**.
     *  Get function Inventory Service
     */
    private final InventoryService inventoryService;

    /**.
     *  Api for Get all inventories
     */
    @Operation(summary = "Get all inventories",
            description = "Retrieve a list of all inventories")
    @GetMapping(PathInventoryAPIs.FIND_ALL)
    public ResponseEntity<ResponseTemplate<ResponseList<InventoryResponseDto>>>
        getAllInventories() {
        return inventoryService.getAllInventories();
    }

    /**.
     *  Api for Get all inventories with pagination
     * @param page number
     */
    @Operation(summary = "Get all inventories by page",
            description = "Retrieves a list of all inventories with pagination")
    @GetMapping(PathInventoryAPIs.FIND_ALL_WITH_PAGE)
    public ResponseEntity<ResponseTemplate<ResponseList<InventoryResponseDto>>>
        getAllInventoriesWithPage(final Pageable page) {
        return inventoryService.getAllInventoriesWithPage(page);
    }

    /**.
     *  Api for Get a inventory
     * @param id
     */
    @Operation(summary = "Get inventory by id",
            description = "Retrieves a spesific inventory by id")
    @GetMapping(PathInventoryAPIs.FIND_ONE)
    public ResponseEntity<ResponseTemplate<ResponseDetail<InventoryResponseDto>>>
        getInventoryById(final @PathVariable Long id) {
        return inventoryService.getInventoryById(id);
    }

    /**.
     *  Api for Create a new inventory
     * @param inventoryDto
     * @return new data inventory
     */
    @Operation(summary = "Create new inventory",
            description = "Create a new inventory")
    @PostMapping(PathInventoryAPIs.CREATE)
    public ResponseEntity<ResponseTemplate<ResponseDetail<InventoryResponseDto>>>
        createInventory(final @RequestBody InventoryRequestDto inventoryDto) {
        return inventoryService.createInventory(inventoryDto);
    }

    /**.
     *  Api for Update a inventory
     * @param id
     * @param inventoryDto
     */
    @Operation(summary = "Update inventory",
            description = "Update a inventory")
    @PutMapping(PathInventoryAPIs.UPDATE)
    public ResponseEntity<ResponseTemplate<ResponseDetail<InventoryResponseDto>>>
        updateInventory(final @RequestBody InventoryRequestDto inventoryDto,
                                            final @PathVariable Long id) {
        return inventoryService.updateInventory(inventoryDto, id);
    }

    /**.
     *  Api for Delete a inventory
     * @param id
     */
    @Operation(summary = "Delete inventory",
            description = "Delete a inventory")
    @DeleteMapping(PathInventoryAPIs.DELETE)
    public void deleteInventory(final @PathVariable Long id) {
        inventoryService.deleteInventory(id);
    }

}