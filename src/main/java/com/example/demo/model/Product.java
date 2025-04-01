package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	private int id;
	private String name;
	private int price;
	private String imageurl;


}
