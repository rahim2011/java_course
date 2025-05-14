package az.developia.book_project.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import az.developia.book_project.dto.BookRequestDto;
import az.developia.book_project.entity.Book;
import az.developia.book_project.entity.User;
import az.developia.book_project.exception.OurRuntimeException;
import az.developia.book_project.repository.BookRepository;
import az.developia.book_project.repository.UserRepository;
import az.developia.book_project.response.BookResponse;



@Service
public class BookService {

	@Autowired
	private BookRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	public void add(BookRequestDto dto) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.getUserByUsername(username);
		Integer id = user.getId();

		Book book = new Book();
		book.setId(null);
		book.setGenre(dto.getGenre());
		book.setRating(dto.getRating());
		book.setTitle(dto.getTitle());
		book.setUserId(id);
		movieRepository.save(book);
	}

	public BookResponse get() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.getUserByUsername(username);
		Integer id = user.getId();

		BookResponse response = new BookResponse();
		response.seBooks(bookRepository.findByUserId(id));
		return response;
	}

	public List<String> getMovieTitle() {
		return movieRepository.getMovieNames();
	}

	public void delete(Integer id) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User operatorUser = userRepository.getUserByUsername(username);
		
		if (id == null || id<=0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}
		Optional<Book> book = bookRepository.findById(id);
		if (movie.isPresent()) {
			if (movie.get().getUserId() == operatorUser.getId()) {
				movieRepository.deleteById(id);
				
			}else {
				throw new OurRuntimeException(null, "oz filminini sil");
			}
		}else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}

	
}
