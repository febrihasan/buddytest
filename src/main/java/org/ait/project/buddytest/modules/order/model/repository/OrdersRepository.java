package org.ait.project.buddytest.modules.order.model.repository;

import org.ait.project.buddytest.modules.order.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}