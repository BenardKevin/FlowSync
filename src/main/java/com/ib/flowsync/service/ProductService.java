package com.ib.flowsync.service;

import com.ib.flowsync.dto.ProductDTO;
import com.ib.flowsync.entity.Category;
import com.ib.flowsync.entity.Product;
import com.ib.flowsync.entity.Supplier;
import com.ib.flowsync.repository.CategoryRepository;
import com.ib.flowsync.repository.ProductRepository;
import com.ib.flowsync.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public void createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(null);
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setVat(productDTO.getVat());

        Optional<Category> category = categoryRepository.findById(productDTO.getCategoryId());
        category.ifPresent(product::setCategory);

        Optional<Supplier> supplier = supplierRepository.findById(productDTO.getSupplierId());
        supplier.ifPresent(product::setSupplier);

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

    public void updateProduct(ProductDTO productDTO, Integer productId) {
        Optional<Product> existingProductOpt = productRepository.findById(productId);

        if (existingProductOpt.isPresent()) {
            Product product = existingProductOpt.get();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setVat(productDTO.getVat());

            Optional<Category> category = categoryRepository.findById(productDTO.getCategoryId());
            category.ifPresent(product::setCategory);

            Optional<Supplier> supplier = supplierRepository.findById(productDTO.getSupplierId());
            supplier.ifPresent(product::setSupplier);

            productRepository.save(product);
        }
    }

    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}
