package com.example.product_ecommerce_finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_ecommerce_finalProject.requestDto.UserRequestDto;
import com.example.product_ecommerce_finalProject.service.UserService;

@RestController
@RequestMapping(path="/users")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/register")
	public void createUser(@RequestBody UserRequestDto dto) {
		userService.create(dto);
	}
}
