package az.developia.book_project.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import az.developia.book_project.dto.UserRequestDto;
import az.developia.book_project.entity.Authorities;
import az.developia.book_project.entity.User;
import az.developia.book_project.exception.InvalidCredentialsException;
import az.developia.book_project.exception.OurRuntimeException;
import az.developia.book_project.repository.AuthorityRepository;
import az.developia.book_project.repository.BookRepository;
import az.developia.book_project.repository.UserRepository;
import az.developia.book_project.util.JwtUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository; // 123
	private final BookRepository bookRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthorityRepository authorityRepository;
	private final JwtUtil jwtUtil;

	@Autowired
	private ModelMapper modelMapper;

	public String create(UserRequestDto dto) {
		Optional<User> byUsername = userRepository.findByUsername(dto.getUsername());
		if (byUsername.isPresent()) {
			throw new OurRuntimeException(null, "Username is exists");
		}

		String encode = passwordEncoder.encode(dto.getPassword());

		User user = new User();
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		modelMapper.map(dto, user);
		user.setPassword(encode);
		userRepository.save(user);

		Authorities a1 = new Authorities();
		a1.setUsername(user.getUsername());
		a1.setAuthority("ROLE_ADD_MOVIE");
		authorityRepository.save(a1);

		return "User create successfully";

	}

	public String login(UserRequestDto dto) {
		Optional<User> user = userRepository.findByUsername(dto.getUsername());

		if (!user.isPresent() || !passwordEncoder.matches(dto.getPassword(), user.get().getPassword())) {
			throw new InvalidCredentialsException("Username or pasword incorrect");
		}

		List<String> authorityList = authorityRepository.findByUsername(user.get().getUsername()).stream()
				.map(Authorities::getAuthority).collect(Collectors.toList());

		return jwtUtil.generateToken(user.get().getUsername(), user.get().getEmail(), authorityList);
	}

	public ResponseEntity<Map<String, Object>> getUserDetail(String token) {
		if (token.startsWith("Bearer")) {
			token = token.substring(7);
		}
		Map<String, Object> claims = jwtUtil.extractClaims(token);
		return ResponseEntity.ok(claims);
	}

	public void delete(Integer id) {
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}
		Optional<User> finded = userRepository.findById(id);
		if (finded.isPresent()) {
			User user = finded.get();
			userRepository.deleteById(id);
			bookRepository.deleteUserBooks(user.getId());
		} else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}
}