package com.example.restservice.repository;

import com.example.restservice.entity.Product;
import com.example.restservice.entity.ProductCategory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

	void save(Product product);

	List<Product> findByCategory(ProductCategory category);

	Optional<Product> findById(Long id);

	void updateOne(Product product);

	void deleteById(Long id);

}
