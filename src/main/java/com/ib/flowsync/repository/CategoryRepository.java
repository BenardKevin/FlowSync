package com.ib.flowsync.repository;

import com.ib.flowsync.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    // JPQL : @Query("SELECT c FROM Category c WHERE c.name = :name")
    // SQL : @Query("SELECT * FROM category WHERE name = :name", nativeQuery = true)
    //Optional<Category> findByName(@Param("name", String name);

    Optional<Category> findByName(String name);
}
