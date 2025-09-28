package com.example.product_ecommerce_finalProject.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.product_ecommerce_finalProject.entity.User;
import com.example.product_ecommerce_finalProject.repository.UserRepository;
import com.example.product_ecommerce_finalProject.requestDto.UserRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	public void create(UserRequestDto dto) {
		Optional<User> byUsername= userRepository.findByUsername(dto.getUsername());
		if(byUsername.isPresent()) {
			throw new RuntimeException("user is exists");
		}
		
    User user= new User();
    user.setId(null);
    user.setName(dto.getName());
    user.setSurname(dto.getSurname());
    user.setUsername(dto.getUsername());
    user.setEmail(dto.getEmail());
    user.setPassword(dto.getPassword());
    userRepository.save(user);
    
		
	}

}
