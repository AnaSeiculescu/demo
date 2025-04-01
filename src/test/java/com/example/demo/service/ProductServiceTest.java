package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.dto.CreateProductDto;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceTest {

	@InjectMocks
	ProductService productService;
	@MockitoBean
	ProductRepository productRepository;

	@Test
	void createProductWhenNoDataExpectException() {

		RuntimeException exception = assertThrows(RuntimeException.class, () -> productService.createProduct(null));
		assertEquals("Missing product data.", exception.getMessage());

	}

	@Test
	void createProductGivenOneProductExpectProductCreated() {

		CreateProductDto createProductDto = new CreateProductDto();
		createProductDto.setName("Laptopvechi");
		createProductDto.setPrice(15);
		createProductDto.setImageurl("http://localhost");
//		doReturn(new Product()).when(productRepository.save(any()));
		when(productRepository.save(any())).thenReturn(new Product());

		Product createdproduct = productService.createProduct(createProductDto);

		Product expectedProduct = new Product();
		expectedProduct.setName("Laptopvechi");
		expectedProduct.setPrice(15);
		expectedProduct.setImageurl("http://localhost");

		assertEquals(expectedProduct, createdproduct);

	}
}