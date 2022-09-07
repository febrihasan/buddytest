package org.ait.project.buddytest.modules.inventory.model.repository;

import org.ait.project.buddytest.modules.inventory.model.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**.
 *  Interface Inventory Repository
 */
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    /**.
     *  Find data inventory by product id
     * @param productId
     * @return data inventory
     */
    Inventory findByProductId(Long productId);

    /**.
     * Update available quantity by product id
     * @param remaining
     * @param productId
     */
    @Transactional
    @Modifying
    @Query("update Inventory i set i.availableQuantity = ?1 where i.productId = ?2")
    void updateQuantity(Long remaining, Long productId);

}