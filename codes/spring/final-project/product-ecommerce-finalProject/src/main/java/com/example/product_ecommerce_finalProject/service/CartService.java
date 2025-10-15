package com.example.product_ecommerce_finalProject.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.product_ecommerce_finalProject.entity.Cart;
import com.example.product_ecommerce_finalProject.entity.Product;
import com.example.product_ecommerce_finalProject.entity.User;
import com.example.product_ecommerce_finalProject.exception.OurRuntimeException;
import com.example.product_ecommerce_finalProject.repository.CartRepository;
import com.example.product_ecommerce_finalProject.repository.ProductRepository;
import com.example.product_ecommerce_finalProject.repository.UserRepository;
import com.example.product_ecommerce_finalProject.requestDto.CartRequestDto;
import com.example.product_ecommerce_finalProject.response.CartResponseDto;



@Service
public class CartService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRepository;

	public void addToCart(CartRequestDto dto) {
		Product product = productRepository.findById(dto.getProductId())
		.orElseThrow(() -> new OurRuntimeException(null, "product not found"));

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.getUserByUsername(username);
		Integer id = user.getId();

		Cart cart = new Cart();
		cart.setProduct(product);
		cart.setQuantity(1);
		Double subTotal = product.getPrice() * cart.getQuantity();
		cart.setSubTotal(subTotal);
		cart.setUserId(id);
		cartRepository.save(cart);
	}

	public List<CartResponseDto> getCart() {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.getUserByUsername(username);
		Integer id = user.getId();

		List<Cart> carts = cartRepository.findAllByUserId(id);
		return carts.stream().map(cart -> {
			CartResponseDto response = new CartResponseDto();
			response.setId(cart.getId());
			response.setProduct(cart.getProduct());
			response.setQuantity(cart.getQuantity());
			response.setUserId(cart.getUserId());
			response.setSubTotal(cart.getSubTotal());
			response.setUserId(id);
			return response;
		})
				.collect(Collectors.toList());
	}

	public void update(CartRequestDto dto) {
		Cart cart = cartRepository.findById(dto.getId())
		.orElseThrow(() -> new OurRuntimeException(null, "cart not found"));

		Integer quantity = (dto.getQuantity() == null || dto.getQuantity() <= 0)? 1 : dto.getQuantity();

		cart.setQuantity(quantity);

		Double subTotal = cart.getProduct().getPrice() * quantity;

		cart.setSubTotal(subTotal);
		cartRepository.save(cart);
	}

	public void delete(Integer id) {
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id absolute");
		}
		
		if (cartRepository.findById(id).isPresent()) {
			cartRepository.deleteById(id);
		}else {
			throw new OurRuntimeException(null, "id not found");
		}
	}

}