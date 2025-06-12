package com.assignment.order_management_system.service;

import com.assignment.order_management_system.dto.ProductDTO;
import com.assignment.order_management_system.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO addProduct(ProductDTO dto);
    ProductResponseDTO updateProduct(Long id, ProductDTO dto);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(Long id);
}
