package com.example.product_ecommerce_finalProject.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
	private Integer id;
	private String name;
	private Double price;
	private String image;
	private String category;
	private Integer rating;
	private String description;
}