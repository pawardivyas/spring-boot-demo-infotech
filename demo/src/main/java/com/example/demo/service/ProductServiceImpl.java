package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable); // Returns paginated list of products
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id); // Finds a product by its ID
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product); // Saves and returns the new product
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return productRepository.findById(id).map(existing -> {
            existing.setName(product.getName());
            existing.setDescription(product.getDescription());
            existing.setPrice(product.getPrice());
            existing.setQuantity(product.getQuantity());
            existing.setCategory(product.getCategory()); // Associate with category
            return productRepository.save(existing); // Save updated product
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id); // Deletes product by its ID
    }
}