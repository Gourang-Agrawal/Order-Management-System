package com.assignment.order_management_system.controller;

import com.assignment.order_management_system.dto.CustomerOrderReportDTO;
import com.assignment.order_management_system.dto.OrderRequestDTO;
import com.assignment.order_management_system.dto.OrderResponseDTO;
import com.assignment.order_management_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping
    public ResponseEntity<OrderResponseDTO> placeOrder(@RequestBody OrderRequestDTO request) {
        return ResponseEntity.ok(orderService.placeOrder(request));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderResponseDTO>> getOrdersByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderService.getOrdersByCustomerId(customerId));
    }

    @GetMapping("/report/total-orders-per-customer")
    public ResponseEntity<List<CustomerOrderReportDTO>> totalOrdersPerCustomer() {
        return ResponseEntity.ok(orderService.getTotalOrdersPerCustomer());
    }

    @GetMapping("/report/top-5-customers")
    public ResponseEntity<List<CustomerOrderReportDTO>> top5Customers() {
        return ResponseEntity.ok(orderService.getTop5Customers());
    }
}
