package com.example.restservice.service;

import com.example.restservice.entity.Product;
import com.example.restservice.entity.ProductCategory;
import com.example.restservice.payload.ProductModel;
import com.example.restservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

	@Autowired
	private final ProductRepository repository;

	public void save(ProductModel product) {
		Product productToSave = Product.builder()
				.description(product.getDescription())
				.category(product.getCategory())
				.price(product.getPrice())
				.build();
		repository.save(productToSave);

	}

	public Optional<Product> findById(long id) {
		return repository.findById(id);
	}

	public List<Product> findByCategory(String category) {
		return repository.findByCategory(ProductCategory.valueOf(category));
	}

	public void updateOneProduct(long id, ProductModel productModel) {
		Product updateProduct = Product.builder()
				.id(id)
				.description(productModel.getDescription())
				.category(productModel.getCategory())
				.price(productModel.getPrice())
				.build();
		repository.updateOne(updateProduct);
	}

	public void deleteProduct(long id) {
		repository.deleteById(id);
	}


}
