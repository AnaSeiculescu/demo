package com.example.demo.model.dto;

import com.example.demo.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.springframework.beans.BeanUtils;


@Data
public class CreateProductDto {
	@NotNull
	private String name;
	@PositiveOrZero
	private int price;
	@NotBlank
	private String imageurl;

	public Product mapToProduct() {
		Product product = new Product();
//		product.setName(name);
//		product.setPrice(price);
//		product.setImageurl(imageurl);

		BeanUtils.copyProperties(this, product);
		return product;
	}
}
