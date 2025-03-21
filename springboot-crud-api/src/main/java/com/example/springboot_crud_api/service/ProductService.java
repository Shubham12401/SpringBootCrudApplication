package com.example.springboot_crud_api.service;

import com.example.springboot_crud_api.dto.ProductResponseDTO;
import com.example.springboot_crud_api.entity.Category;
import com.example.springboot_crud_api.entity.Product;
import com.example.springboot_crud_api.exception.ResourceNotFoundException;
import com.example.springboot_crud_api.repository.CategoryRepository;
import com.example.springboot_crud_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Product> getAllProducts(PageRequest pageRequest) {
        return productRepository.findAll(pageRequest);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        return new ProductResponseDTO(
                product.getId(),
                product.getName(),  
                product.getPrice(),
                product.getCategory()
              
        );
    }

    
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());

        Category category = categoryRepository.findById(updatedProduct.getCategory().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + updatedProduct.getCategory().getId()));
        existingProduct.setCategory(category);

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        productRepository.delete(product);
    }
}
