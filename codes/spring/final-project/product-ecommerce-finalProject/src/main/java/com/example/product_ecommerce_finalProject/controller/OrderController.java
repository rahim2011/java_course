package com.example.product_ecommerce_finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_ecommerce_finalProject.entity.Order;
import com.example.product_ecommerce_finalProject.exception.OurRuntimeException;
import com.example.product_ecommerce_finalProject.requestDto.OrderRequestDto;
import com.example.product_ecommerce_finalProject.response.OrderResponseDto;
import com.example.product_ecommerce_finalProject.service.OrderService;


import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/orders")
@CrossOrigin(origins = "*")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping(path = "/add")
	public ResponseEntity<String> order(@Valid @RequestBody OrderRequestDto dto, BindingResult br){
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "melumatlarin tamliginda problem var");
		}
		orderService.order(dto);
		return ResponseEntity.ok("Order was created successfully");
	}
	
	/*get order apisi*/
	@GetMapping(path="/getOrder")
	  public List<OrderResponseDto> getAllOrders() {
        return orderService.getAllOrders();
	
	}}
