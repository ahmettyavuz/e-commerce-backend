package com.workintech.ecommerce_backend.repository;


import com.workintech.ecommerce_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value="SELECT p FROM Product p WHERE p.name= :name")
    List<Product> getByName(String name);
    @Query(value="SELECT p FROM Product p WHERE p.category= :categoryId")
    List<Product> getByCategory(Long categoryId);

}
