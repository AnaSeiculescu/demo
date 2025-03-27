package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> findProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public void createProduct(Product product) {productRepository.save(product);}

    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }
}
