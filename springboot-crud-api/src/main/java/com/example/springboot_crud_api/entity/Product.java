package com.example.springboot_crud_api.entity;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id") 
    private Category category;

    
    public Product() {}

    public Product(String name, double price, Category category_id) {
        this.name = name;
        this.price = price;
        this.category = category_id;
    }

   
    public Long getId() {
        return id;
    }

    public String getName() {  
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {  
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
