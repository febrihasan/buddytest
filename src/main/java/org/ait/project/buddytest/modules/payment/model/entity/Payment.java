package org.ait.project.buddytest.modules.payment.model.entity;

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
 * Class Entity Payment
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Payment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @CreationTimestamp
    @Column(name = "transaction_date")
    private ZonedDateTime transactionDate;

    @Column(name = "amount", precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "reference_number", nullable = false, length = 20)
    private String referenceNumber;

    @Column(name = "source_account", nullable = false, length = 20)
    private String sourceAccount;

    @Column(name = "sender_name", nullable = false, length = 50)
    private String senderName;

    @Column(name = "sender_bank_code", nullable = false, length = 10)
    private String senderBankCode;

    @Column(name = "sender_bank_name", nullable = false, length = 50)
    private String senderBankName;

    @Column(name = "target_account", nullable = false, length = 20)
    private String targetAccount;

    @Column(name = "receiver_name", nullable = false, length = 50)
    private String receiverName;

    @Column(name = "receiver_bank_code", nullable = false, length = 10)
    private String receiverBankCode;

    @Column(name = "receiver_bank_name", nullable = false, length = 50)
    private String receiverBankName;

    @Column(name = "status", length = 10)
    private String status;

    @Column(name = "description", length = 100)
    private String description;

}