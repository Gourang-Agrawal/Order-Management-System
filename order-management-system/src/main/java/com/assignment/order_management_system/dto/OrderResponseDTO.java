package com.assignment.order_management_system.dto;


import java.math.BigDecimal;

import java.util.List;

public class OrderResponseDTO {

    private Long orderId;

    private Long customerId;

    private BigDecimal totalAmount;

    private List<ProductItem> items;

    public static class ProductItem {

        private String productName;

        private Integer quantity;

        public ProductItem(String productName, Integer quantity) {

            this.productName = productName;

            this.quantity = quantity;

        }

        public String getProductName() { return productName; }

        public Integer getQuantity() { return quantity; }

    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<ProductItem> getItems() {
        return items;
    }

    public void setItems(List<ProductItem> items) {
        this.items = items;
    }
}

