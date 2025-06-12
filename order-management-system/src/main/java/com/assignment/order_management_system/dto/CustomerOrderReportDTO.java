package com.assignment.order_management_system.dto;

public class CustomerOrderReportDTO {

    private String customerName;
    private Long totalOrders;


    public CustomerOrderReportDTO(String customerName, Long totalOrders) {
        this.customerName = customerName;
        this.totalOrders = totalOrders;
    }
    public String getCustomerName() { return customerName; }
    public Long getTotalOrders() { return totalOrders; }
}
