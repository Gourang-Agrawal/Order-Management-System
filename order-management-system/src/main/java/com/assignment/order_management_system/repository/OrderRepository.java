package com.assignment.order_management_system.repository;

import com.assignment.order_management_system.dto.CustomerOrderReportDTO;
import com.assignment.order_management_system.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);

    @Query("SELECT new com.assignment.order_management_system.dto.CustomerOrderReportDTO(o.customer.name, COUNT(o)) " +

            "FROM Order o GROUP BY o.customer.name")

    List<CustomerOrderReportDTO> getTotalOrdersPerCustomer();

    @Query("SELECT new com.assignment.order_management_system.dto.CustomerOrderReportDTO(o.customer.name, COUNT(o)) " +

            "FROM Order o GROUP BY o.customer.name ORDER BY COUNT(o) DESC")

    List<CustomerOrderReportDTO> getTopCustomers(Pageable pageable);

}