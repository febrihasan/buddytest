package org.ait.project.buddytest.modules.order.model.repository;

import java.math.BigDecimal;
import org.ait.project.buddytest.modules.order.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Transactional
    @Modifying
    @Query("update Orders o set o.amount = ?1 where o.id = ?2")
    void updateTotalAmount(BigDecimal amount, Long id);

}