package com.ib.flowsync.controller;

import com.ib.flowsync.entity.Product;
import com.ib.flowsync.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("")
    public ResponseEntity<String> createProduct(
            @RequestBody Product product
    ) {
        productService.createProduct(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Product creation was successful");
    }

    @GetMapping("")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/{productId}")
    public @ResponseBody Product getProductById(
            @PathVariable(value = "productId") Integer productId
    ) throws ResponseStatusException {
        Product product = productService.getProductById(productId);

        if(product == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");

        return product;
    }

    @PutMapping("/{productId}")
    public ResponseEntity<String> updateProduct(
            @PathVariable(value = "productId") Integer productId,
            @RequestBody Product product
    ) {
        productService.updateProduct(product, productId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Product update was successful");

    }

    @DeleteMapping("/{productId}")
    public @ResponseBody void deleteProduct(
            @PathVariable(value = "productId") Integer productId
    ) {
        productService.deleteProduct(productId);
    }
}
