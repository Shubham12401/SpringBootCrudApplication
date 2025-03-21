package com.example.springboot_crud_api.repository;

import com.example.springboot_crud_api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
