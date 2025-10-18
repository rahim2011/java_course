package com.example.product_ecommerce_finalProject.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.product_ecommerce_finalProject.entity.User;
import com.example.product_ecommerce_finalProject.exception.OurRuntimeException;
import com.example.product_ecommerce_finalProject.repository.UserRepository;
import com.example.product_ecommerce_finalProject.requestDto.UserRequestDto;
import com.example.product_ecommerce_finalProject.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;

	public void create(UserRequestDto dto) {
		Optional<User> byUsername = userRepository.findByUsername(dto.getUsername());
		if (byUsername.isPresent()) {
			throw new OurRuntimeException(null, "user is exists");
		}

		User user = new User();
		user.setId(null);
		user.setName(dto.getName());
		user.setSurname(dto.getSurname());
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		String encode = passwordEncoder.encode(dto.getPassword());
		user.setPassword(encode);
		userRepository.save(user);

	}

	public String login(UserRequestDto d) {
		Optional<User> user = userRepository.findByUsername(d.getUsername());

		if (!user.isPresent() || !passwordEncoder.matches(d.getPassword(), user.get().getPassword())) {
			throw new OurRuntimeException(null, "Username or password is incorrect.");
		}

		return jwtUtil.generateToken(user.get().getUsername(), user.get().getName(), user.get().getSurname(),
				user.get().getEmail());

	}

}
