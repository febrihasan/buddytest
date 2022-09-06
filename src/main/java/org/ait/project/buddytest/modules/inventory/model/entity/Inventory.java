package org.ait.project.buddytest.modules.inventory.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ait.project.buddytest.modules.customer.model.entity.Customer;
import org.ait.project.buddytest.modules.product.model.entity.Product;
import org.ait.project.buddytest.shared.constant.entities.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**.
 * Class Entity Product
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "available_quantity")
    private Long availableQuantity;

}