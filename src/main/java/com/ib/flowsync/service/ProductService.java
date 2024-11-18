package com.ib.flowsync.service;

import com.ib.flowsync.entity.Category;
import com.ib.flowsync.entity.Product;
import com.ib.flowsync.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void createProduct(Product product) {
        product.setId(null);
        productRepository.save(product);
    }

    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public List<Product> getProductByName(String name) {
        return (List<Product>) productRepository.findByName(name);
    }

    public List<Product> getProductByCategory(Category category) {
        return (List<Product>) productRepository.findByCategory(category);
    }

    public void updateProduct(Product product, Integer productId) {
        product.setId(productId);
        productRepository.save(product);
    }

    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}
