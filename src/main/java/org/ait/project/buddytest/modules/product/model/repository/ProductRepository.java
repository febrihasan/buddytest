package org.ait.project.buddytest.modules.product.model.repository;

import org.ait.project.buddytest.modules.product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Transactional
    @Modifying
    @Query("update Product p set p.isStock = ?1 where p.id = ?2")
    void updateStockProduct(Boolean flag, Long id);
}