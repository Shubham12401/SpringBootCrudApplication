package com.example.springboot_crud_api.dto;

import com.example.springboot_crud_api.entity.Category;

public class ProductResponseDTO {
	private Long id;
	private String name;
	private double price;
	private Category category;
	private Long categoryId;

	
	public ProductResponseDTO(Long id, String name, double price, Category category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
