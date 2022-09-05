package org.ait.project.buddytest.modules.customer.model.repository;

import org.ait.project.buddytest.modules.customer.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}