package org.ait.project.buddytest.modules.inventory.service.delegate.impl;

import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.inventory.exception.JPHNotFoundException;
import org.ait.project.buddytest.modules.inventory.model.entity.Inventory;
import org.ait.project.buddytest.modules.inventory.model.repository.InventoryRepository;
import org.ait.project.buddytest.modules.inventory.service.delegate.InventoryDelegate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**.
 * Class Inventory Delegate Implements
 */
@Service
@RequiredArgsConstructor
public class InventoryDelegateImpl implements InventoryDelegate {

  private final InventoryRepository repository;

  public List<Inventory> getAllInventories() {
    return repository.findAll();
  }

  @Override
  public Page<Inventory> getAllInventoriesWithPage(final Pageable page) {
    return repository.findAll(page);
  }

  @Override
  public Inventory getInventoryById(final Long id) {
    return repository.findById(id).orElseThrow(JPHNotFoundException::new);
  }

  @Override
  public Inventory getInventoryByProductId(final Long productId) {
    return repository.findByProductId(productId);
  }

  @Override
  public void updateQuantity(final Long remaining, final Long productId) {
    repository.updateQuantity(remaining, productId);
  }

  @Override
  public List<Inventory> saveAll(final List<Inventory> inventoryList) {
    return repository.saveAll(inventoryList);
  }

  @Override
  public Inventory save(final Inventory inventory) {
    return repository.save(inventory);
  }

  @Override
  public void deleteById(final Long id) {
    repository.deleteById(id);
  }

}
