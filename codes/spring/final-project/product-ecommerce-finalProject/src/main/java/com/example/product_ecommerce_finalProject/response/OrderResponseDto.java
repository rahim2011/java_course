package com.example.product_ecommerce_finalProject.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

	private Integer id;
	private String firstName;
	private String lastName;
	private String country;
	private String address; 
	private String city;
	private String phone;
	private String email;
	private String cartNumber;
	private String zipCode;
	private String expiryMonth;
	private Integer expiryYear;
	

}
