package com.example.product_ecommerce_finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_ecommerce_finalProject.exception.OurRuntimeException;
import com.example.product_ecommerce_finalProject.requestDto.UserRequestDto;
import com.example.product_ecommerce_finalProject.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/users")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/register")
	public void createUser( @Valid @RequestBody UserRequestDto dto, BindingResult br) {
		if(br.hasErrors()) {
			throw new OurRuntimeException(br,"");
		}
		userService.create(dto);
	}
	@PostMapping(path="/login")
	public String userLogin(@RequestBody UserRequestDto d) {
		return userService.login(d);
	}
}
