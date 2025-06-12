package com.assignment.order_management_system.service;

import com.assignment.order_management_system.dto.CustomerOrderReportDTO;
import com.assignment.order_management_system.dto.OrderRequestDTO;
import com.assignment.order_management_system.dto.OrderResponseDTO;

import java.util.List;

public interface OrderService {
    OrderResponseDTO placeOrder(OrderRequestDTO request);
    List<OrderResponseDTO> getOrdersByCustomerId(Long customerId);

    List<CustomerOrderReportDTO> getTotalOrdersPerCustomer();
    List<CustomerOrderReportDTO> getTop5Customers();
}
