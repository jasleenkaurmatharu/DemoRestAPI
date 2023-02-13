package com.example.restservice.payload;

import com.example.restservice.entity.ProductCategory;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ProductModel {

	private ProductCategory category;
	private String description;
	private Long price;
}
