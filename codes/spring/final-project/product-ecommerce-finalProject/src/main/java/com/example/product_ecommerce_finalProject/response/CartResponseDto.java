package com.example.product_ecommerce_finalProject.response;



import com.example.product_ecommerce_finalProject.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {
	private Integer id;
	private Integer quantity;
	private Double subTotal;
	private Product product;
	
	private Integer userId;
}