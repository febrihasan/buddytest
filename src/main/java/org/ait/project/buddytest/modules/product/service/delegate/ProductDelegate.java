package org.ait.project.buddytest.modules.product.service.delegate;

import org.ait.project.buddytest.modules.product.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductDelegate {

  List<Product> getAllProducts();

  Page<Product> getAllProductsWithPage(Pageable page);

  Product getProductById(Long id);

  List<Product> saveAll(List<Product> products);

  Product save(Product product);

  void deleteById(Long id);

}
