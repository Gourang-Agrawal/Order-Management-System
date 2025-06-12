package com.assignment.order_management_system.service;

import com.assignment.order_management_system.dto.ProductDTO;
import com.assignment.order_management_system.dto.ProductResponseDTO;
import com.assignment.order_management_system.entity.Product;
import com.assignment.order_management_system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponseDTO addProduct(ProductDTO dto) {

        Product product = new Product(dto.getName(), dto.getPrice(), dto.getStock());

        return toDTO(productRepository.save(product));

    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductDTO dto) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(dto.getName());

        product.setPrice(dto.getPrice());

        product.setStock(dto.getStock());

        return toDTO(productRepository.save(product));

    }
    @Override
    public List<ProductResponseDTO> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public ProductResponseDTO getProductById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return toDTO(product);
    }

    private ProductResponseDTO toDTO(Product product) {

        return new ProductResponseDTO(

                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock()
        );

    }

}

