package com.example.springboot_crud_api.repository;

import com.example.springboot_crud_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
