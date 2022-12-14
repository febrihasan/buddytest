package org.ait.project.buddytest.modules.order.model.entity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
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
import org.hibernate.annotations.CreationTimestamp;

/**.
 * Class Entity Orders
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "amount", precision = 15, scale = 2)
    private BigDecimal amount;

    @CreationTimestamp
    @Column(name = "order_date")
    private ZonedDateTime orderDate;

    @Column(name = "order_number", nullable = false)
    private String orderNumber;

}