package com.example.restservice.repository;

import com.example.restservice.entity.Product;
import com.example.restservice.entity.ProductCategory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class JdbcProductRepositoryIntTest {

	@Autowired
	@Qualifier("serviceNamedParameterJdbcTemplate")
	NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	ProductRepository productRepository;

	@BeforeEach
	void setUp() {
		jdbcTemplate.update("INSERT INTO product (category, description, price)" + "VALUES ('BOOKS', 'Lord of the flies', '15');", new MapSqlParameterSource());
	}

	@AfterEach
	void tearDown() {
		jdbcTemplate.getJdbcTemplate().execute("TRUNCATE TABLE product");
	}

	@Test
	@DisplayName("find product gets product from db")
	void findProductById() {
		List<Product> product = productRepository.findByCategory(ProductCategory.BOOKS);

		assertEquals("BOOKS", product.get(0).category().toString());

	}


}
