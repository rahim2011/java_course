package com.example.product_ecommerce_finalProject.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
 @Setter
 @AllArgsConstructor
 @NoArgsConstructor
public class UserRequestDto {
	private Integer id;
	private String name;
	private String surname;
	private String email;
	private String username;
	private String password;
}
