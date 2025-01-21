package com.example.demo.service;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {
    Page<Product> getAllProducts(Pageable pageable); // Paginated fetch
    Optional<Product> getProductById(Long id); // Fetch product by ID
    Product createProduct(Product product); // Create a new product
    Product updateProduct(Long id, Product product); // Update product by ID
    void deleteProduct(Long id); // Delete product by ID
}