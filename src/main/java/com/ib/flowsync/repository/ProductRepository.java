package com.ib.flowsync.repository;

import com.ib.flowsync.entity.Category;
import com.ib.flowsync.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    Iterable<Product> findByName(String name);
    Iterable<Product> findByCategory(Category category);
}
