package com.assignment.order_management_system.service;

import com.assignment.order_management_system.dto.CustomerOrderReportDTO;
import com.assignment.order_management_system.dto.OrderRequestDTO;
import com.assignment.order_management_system.dto.OrderResponseDTO;
import com.assignment.order_management_system.dto.OrderResponseDTO.ProductItem;
import com.assignment.order_management_system.entity.*;
import com.assignment.order_management_system.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service

public class OrderServiceImpl implements OrderService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderResponseDTO placeOrder(OrderRequestDTO request) {

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        List<OrderItem> orderItems = new ArrayList<>();

        BigDecimal totalAmount = BigDecimal.ZERO;

        for (OrderRequestDTO.ProductQuantity pq : request.getProducts()) {

            Product product = productRepository.findById(pq.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getStock() < pq.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }

            product.setStock(product.getStock() - pq.getQuantity());

            productRepository.save(product);

            OrderItem item = new OrderItem();

            item.setProduct(product);

            item.setQuantity(pq.getQuantity());

            orderItems.add(item);

            BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(pq.getQuantity()));

            totalAmount = totalAmount.add(itemTotal);

        }

        Order order = new Order();

        order.setCustomer(customer);

        order.setTotalAmount(totalAmount);

        order.setItems(orderItems);

        for (OrderItem item : orderItems) {
            item.setOrder(order);
        }

        Order savedOrder = orderRepository.save(order);

        List<ProductItem> responseItems = new ArrayList<>();

        for (OrderItem item : savedOrder.getItems()) {

            responseItems.add(new ProductItem(item.getProduct().getName(), item.getQuantity()));

        }

        OrderResponseDTO response = new OrderResponseDTO();

        response.setOrderId(savedOrder.getId());

        response.setCustomerId(customer.getId());

        response.setTotalAmount(savedOrder.getTotalAmount());

        response.setItems(responseItems);

        return response;

    }

    @Override
    public List<OrderResponseDTO> getOrdersByCustomerId(Long customerId) {

        List<Order> orders = orderRepository.findByCustomerId(customerId);

        List<OrderResponseDTO> responseList = new ArrayList<>();

        for (Order order : orders) {
            List<ProductItem> items = new ArrayList<>();

            for (OrderItem item : order.getItems()) {
                items.add(new ProductItem(item.getProduct().getName(), item.getQuantity()));
            }

            OrderResponseDTO dto = new OrderResponseDTO();

            dto.setOrderId(order.getId());

            dto.setCustomerId(order.getCustomer().getId());

            dto.setTotalAmount(order.getTotalAmount());

            dto.setItems(items);

            responseList.add(dto);

        }


        return responseList;

    }

    @Override
    public List<CustomerOrderReportDTO> getTotalOrdersPerCustomer() {
        return orderRepository.getTotalOrdersPerCustomer();
    }

    @Override
    public List<CustomerOrderReportDTO> getTop5Customers() {
        return orderRepository.getTopCustomers(PageRequest.of(0, 5));
    }

}

