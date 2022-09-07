package org.ait.project.buddytest.modules.payment.model.repository;

import org.ait.project.buddytest.modules.payment.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    /**
     * Retrive payment
     * @param referenceNumber
     */
    @Query("select p from Payment p where p.referenceNumber = ?1")
    Payment getPaymentByReferenceNumber(String referenceNumber);

    @Transactional
    @Modifying
    @Query("update Payment p set p.status = ?1 where p.referenceNumber = ?2")
    void updateStatusByReferenceNumber(String status, String referenceNumber);



}