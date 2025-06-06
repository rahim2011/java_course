package az.developia.book_project.service;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	public void add(BookRequestDto dto) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.getUserByUsername(username);
		Integer id = user.getId();

		Book book = new Book();
		book.setId(null);
        book.setYear(dto.getYear());
        book.setAuthor(dto.getAuthor());
		book.setTitle(dto.getTitle());
	book.setUserId(id);
		bookRepository.save(book);
	}

	public BookResponse get() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.getUserByUsername(username);
		Integer id = user.getId();

		BookResponse response = new BookResponse();


		List<Book> books=bookRepository.findByUserId(id); 

		Function<Book, String> f = new Function<Book, String>() {

			@Override
			public String apply(Book t) {
				return t.getTitle();
			}
		};

		Predicate<String> pre=new Predicate<String>() {

			@Override
			public boolean test(String t) {
				return t.contains("a");
			}
		};

	
  
		List<String> filteredBooks =books.stream()
				.map(f).filter(pre).collect(Collectors.toList());
		response.setBooks(filteredBooks);


		return response;
	}

	public List<String> getBookTitle() {
		return bookRepository.getBookNames();
	}

	public void delete(Integer id) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User operatorUser = userRepository.getUserByUsername(username);

		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}

		Book book = bookRepository.findById(id).orElseThrow(() -> new OurRuntimeException(null, "id tapilmadi"));
		
		Supplier<OurRuntimeException> s = new Supplier<OurRuntimeException>() {
			
			@Override
			public OurRuntimeException get() {
				return new OurRuntimeException(null, "id tapilmadi");
			}
		};
		

		if (book.getUserId() == operatorUser.getId()) {
		bookRepository.deleteById(id);

		} else {
			throw new OurRuntimeException(null, "oz filminini sil");
		}
	}

}
