package org.ait.project.buddytest.modules.inventory.service.delegate;

import org.ait.project.buddytest.modules.inventory.model.entity.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InventoryDelegate {

  List<Inventory> getAllInventories();

  Page<Inventory> getAllInventoriesWithPage(Pageable page);

  Inventory getInventoryById(Long id);

  List<Inventory> saveAll(List<Inventory> inventories);

  Inventory save(Inventory inventory);

  void deleteById(Long id);

}
