package org.ait.project.buddytest.modules.product.model.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ait.project.buddytest.shared.constant.entities.BaseEntity;

/**.
 * Class Entity Product
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type", length = 20)
    private String type;

    @Column(name = "seri_name", length = 50)
    private String seriName;

    @Column(name = "price", length = 20)
    private BigDecimal price;

}