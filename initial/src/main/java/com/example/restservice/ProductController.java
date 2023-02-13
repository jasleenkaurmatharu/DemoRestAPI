package com.example.restservice;

import com.example.restservice.entity.Product;
import com.example.restservice.payload.ProductModel;
import com.example.restservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private final ProductService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductModel productModel) {
		service.save(productModel);
	}

	@GetMapping("/{category}")
	public ResponseEntity<List<Product>> getProduct(@PathVariable("category")String category) {
		return new ResponseEntity<>(service.findByCategory(category), HttpStatus.OK);
	}

	@GetMapping("/getID/{id}")
	public ResponseEntity<Optional<Product>> getProduct(@PathVariable("id")long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateOneProduct(@PathVariable("id")long id, @RequestBody ProductModel productModel) {
		service.updateOneProduct(id, productModel);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOneProduct(@PathVariable("id")long id) {
		service.deleteProduct(id);
	}



}
