package com.example.product_ecommerce_finalProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_ecommerce_finalProject.entity.Cart;
import com.example.product_ecommerce_finalProject.entity.Order;
import com.example.product_ecommerce_finalProject.exception.OurRuntimeException;
import com.example.product_ecommerce_finalProject.repository.CartRepository;
import com.example.product_ecommerce_finalProject.repository.OrderRepository;
import com.example.product_ecommerce_finalProject.requestDto.OrderRequestDto;



@Service
public class OrderService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	public void order(OrderRequestDto dto) {
		Cart cart = cartRepository.findById(dto.getCartId())
		.orElseThrow(() -> new OurRuntimeException(null, "cart not found"));
		
		Order order = new Order();
		order.setFirstName(dto.getFirstName());
		order.setLastName(dto.getLastName());
		order.setCountry(dto.getCountry());
		order.setAddress(dto.getAddress());
		order.setCity(dto.getCity());
		order.setPhone(dto.getPhone());
		order.setEmail(dto.getEmail());
		order.setCartNumber(dto.getCartNumber());
		order.setExpiryMonth(dto.getExpiryMonth());
		order.setExpiryYear(dto.getExpiryYear());
		order.setZipCode(dto.getZipCode());;
		order.setCart(cart);
		orderRepository.save(order);
	}

	
}