package org.ait.project.buddytest.modules.inventory.model.transform;

import java.util.List;
import org.ait.project.buddytest.modules.inventory.dto.request.InventoryRequestDto;
import org.ait.project.buddytest.modules.inventory.dto.response.InventoryResponseDto;
import org.ait.project.buddytest.modules.inventory.model.entity.Inventory;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**.
 *  Interface Transform model to DTO or DTO to model
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InventoryTransform {
    Inventory inventoryDtoToInventory(InventoryRequestDto inventoryRequestDto);

    InventoryResponseDto inventoryToInventoryDto(Inventory inventory);

    List<InventoryResponseDto> inventoriesToInventoriesDto(List<Inventory> inventories);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Inventory updateInventoryFromInventoryDto(InventoryRequestDto inventoryDto,
                                              @MappingTarget Inventory inventory);
}
