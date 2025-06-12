package com.assignment.order_management_system.repository;

import com.assignment.order_management_system.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderitemRepository extends JpaRepository<OrderItem, Long> {
}
