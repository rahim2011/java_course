package com.example.product_ecommerce_finalProject.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.product_ecommerce_finalProject.entity.Product;
import com.example.product_ecommerce_finalProject.entity.User;
import com.example.product_ecommerce_finalProject.exception.OurRuntimeException;
import com.example.product_ecommerce_finalProject.repository.ProductRepository;
import com.example.product_ecommerce_finalProject.repository.UserRepository;
import com.example.product_ecommerce_finalProject.requestDto.ProductRequestDto;
import com.example.product_ecommerce_finalProject.response.ProductListResponse;
import com.example.product_ecommerce_finalProject.response.ProductResponseDto;



@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	public void create(ProductRequestDto d) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.getUserByUsername(username);
		Integer id = user.getId();

		Product product = new Product();
		product.setId(null);
		product.setName(d.getName());
		product.setModel(d.getModel());
		product.setPrice(d.getPrice());
		product.setImage(d.getImage());
		product.setCategory(d.getCategory());
		product.setRating(d.getRating());
		product.setDescription(d.getDescription());
		product.setUserId(id);
		productRepository.save(product);
	}

	public ProductListResponse getAll() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.getUserByUsername(username);
		Integer id = user.getId();

		List<Product> products = productRepository.findAllByUserId(id);
		ProductListResponse response = new ProductListResponse();
		response.setProducts(products);
		return response;
	}

	public ProductResponseDto get(Integer id) {
		if (id == null || id<=0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}
		Optional<Product> byId = productRepository.findById(id);
		ProductResponseDto response = new ProductResponseDto();
		if (byId.isPresent()) {
			Product product = byId.get();
			response.setId(product.getId());
			response.setName(product.getName());
			response.setModel(product.getModel());
			response.setPrice(product.getPrice());
			response.setImage(product.getImage());
			response.setCategory(product.getCategory());
			response.setRating(product.getRating());
			response.setDescription(product.getDescription());
		}else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
		return response;
	}

	public void update(ProductRequestDto dto) {
		if (dto.getId() == null || dto.getId() <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}
		Optional<Product> byId = productRepository.findById(dto.getId());
		if (byId.isPresent()) {
			Product product = byId.get();
			product.setId(dto.getId());
			product.setName(dto.getName());
			product.setModel(dto.getModel());
			product.setPrice(dto.getPrice());
			product.setImage(dto.getImage());
			product.setCategory(dto.getCategory());
			product.setRating(dto.getRating());
			product.setDescription(dto.getDescription());
			productRepository.save(product);
		}else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}

	public void delete(Integer id) {
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}
		if (productRepository.findById(id).isPresent()) {
			productRepository.deleteById(id);
		}else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}

	}

	public ProductListResponse getAllProduct() {
		ProductListResponse response = new ProductListResponse();
		List<Product> all = productRepository.findAll();
		response.setProducts(all);
		return response;
	}

	public List<ProductResponseDto> search(String query) {
		List<Product> products = productRepository.findAll();
		return products.stream().filter(product -> product.getName().toLowerCase().contains(query.toLowerCase()))
				.map(product -> {
					ProductResponseDto response = new ProductResponseDto();
					response.setId(product.getId());
					response.setName(product.getName());
					response.setModel(product.getModel());
					response.setPrice(product.getPrice());
					response.setImage(product.getImage());
					response.setCategory(product.getCategory());
					response.setRating(product.getRating());
					response.setDescription(product.getDescription());
					return response;
				})
				.collect(Collectors.toList());
	}

	public List<ProductResponseDto> sortedProduct(String sort) {
		List<Product> products;
		
		if ("priceAsc".equalsIgnoreCase(sort)) {
			products = productRepository.findAllByOrderByPriceAsc();
		}else if("priceDesc".equalsIgnoreCase(sort)) {
			products = productRepository.findAllByOrderByPriceDesc();
		}else {
			products = productRepository.findAll();
		}
		return products.stream().map(product -> {
			ProductResponseDto response = new ProductResponseDto();
			response.setId(product.getId());
			response.setName(product.getName());
			response.setModel(product.getModel());
			response.setPrice(product.getPrice());
			response.setImage(product.getImage());
			response.setCategory(product.getCategory());
			response.setRating(product.getRating());
			response.setDescription(product.getDescription());
			return response;
		})
				.collect(Collectors.toList());
	}

}