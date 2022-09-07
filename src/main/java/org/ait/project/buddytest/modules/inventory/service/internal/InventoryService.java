package org.ait.project.buddytest.modules.inventory.service.internal;

import org.ait.project.buddytest.modules.inventory.dto.request.InventoryRequestDto;
import org.ait.project.buddytest.modules.inventory.dto.response.InventoryResponseDto;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**.
 * Interface Inventory Service
 */
public interface InventoryService {

    public ResponseEntity<ResponseTemplate<ResponseList<InventoryResponseDto>>>
    getAllInventories();

    public ResponseEntity<ResponseTemplate<ResponseList<InventoryResponseDto>>>
    getAllInventoriesWithPage(Pageable page);

    public ResponseEntity<ResponseTemplate<ResponseDetail<InventoryResponseDto>>>
    getInventoryById(Long id);

    public ResponseEntity<ResponseTemplate<ResponseDetail<InventoryResponseDto>>>
    createInventory(InventoryRequestDto inventoryDto);

    public ResponseEntity<ResponseTemplate<ResponseDetail<InventoryResponseDto>>>
    updateInventory(InventoryRequestDto inventoryDto, Long id);

    public void deleteInventory(Long id);

}
