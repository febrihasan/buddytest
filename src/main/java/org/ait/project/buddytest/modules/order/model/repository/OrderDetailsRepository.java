package org.ait.project.buddytest.modules.order.model.repository;

import org.ait.project.buddytest.modules.order.model.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    @Query("select o from OrderDetails o where o.orderId = ?1")
    List<OrderDetails> findByOrderId(Long orderId);
}