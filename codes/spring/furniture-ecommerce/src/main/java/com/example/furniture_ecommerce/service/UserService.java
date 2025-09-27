package com.example.furniture_ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.furniture_ecommerce.entity.User;
import com.example.furniture_ecommerce.repository.UserRepository;
import com.example.furniture_ecommerce.requestDto.UserRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
private final UserRepository userRepository;

	public void create(UserRequestDto dto) {
		Optional<User> byUsername = userRepository.finByUsername(dto.getUsername());
		if (byUsername.isPresent()) {
			throw new RuntimeException("user is exists");
		}
	User user=new User();
	user.setId(null);
	user.setSurname(dto.getSurname());
	user.setUsername(dto.getUsername());
	user.setEmail(dto.getEmail());
	user.setPassword(dto.getPassword());
	userRepository.save(user);
		
	}

}
