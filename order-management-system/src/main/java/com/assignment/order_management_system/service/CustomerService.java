package com.assignment.order_management_system.service;

import com.assignment.order_management_system.dto.CustomerDTO;
import com.assignment.order_management_system.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {

    CustomerResponseDTO addCustomer(CustomerDTO customerDto);

    CustomerResponseDTO updateCustomer(Long id, CustomerDTO customerDto);

    CustomerResponseDTO getCustomerById(Long id);

    List<CustomerResponseDTO> getAllCustomers();


}
