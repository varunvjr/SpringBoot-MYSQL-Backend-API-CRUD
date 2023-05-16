package com.example.srpingbootcrudsql.repository;

import com.example.srpingbootcrudsql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);

}
