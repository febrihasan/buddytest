package org.ait.project.buddytest.modules.product.model.repository;

import org.ait.project.buddytest.modules.product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}