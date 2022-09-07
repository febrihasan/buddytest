package org.ait.project.buddytest.modules.inventory.service.delegate;

import java.util.List;
import org.ait.project.buddytest.modules.inventory.model.entity.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InventoryDelegate {

  List<Inventory> getAllInventories();

  Page<Inventory> getAllInventoriesWithPage(Pageable page);

  Inventory getInventoryById(Long id);

  Inventory getInventoryByProductId(Long productId);

  void updateQuantity(Long remaining, Long productId);

  List<Inventory> saveAll(List<Inventory> inventories);

  Inventory save(Inventory inventory);

  void deleteById(Long id);

}
