package az.developia.book_project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import az.developia.book_project.dto.BookRequestDto;
import az.developia.book_project.entity.Book;
import az.developia.book_project.entity.TestEntity;
import az.developia.book_project.entity.User;
import az.developia.book_project.exception.OurRuntimeException;
import az.developia.book_project.repository.BookRepository;
import az.developia.book_project.repository.UserRepository;
import az.developia.book_project.repository.ViewRepository;
import az.developia.book_project.response.BookResponse;
import az.developia.book_project.response.BookResponseDto;
import az.developia.book_project.response.BookResponseModel;
import jakarta.persistence.criteria.Predicate;
import jakarta.validation.Valid;


@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ViewRepository viewRepository;

	@Autowired
	private ModelMapper mapper;


	public void add(BookRequestDto dto) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.getUserByUsername(username);
		Integer id = user.getId();

		Book book = new Book();
		book.setId(null);
//		movie.setGenre(dto.getGenre());
//		movie.setRating(dto.getRating());
//		movie.setTitle(dto.getTitle());
		mapper.map(dto, book);
		book.setUserId(id);
		bookRepository.save(book);
	}

	public BookResponse get() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.getUserByUsername(username);
		Integer id = user.getId();

		BookResponse response = new BookResponse();
//		response.setMovies(movieRepository.findByUserId(id));

		List<Book> books = bookRepository.findByUserId(id); 
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

		List<String> filteredBooks = books.stream()
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

		Supplier<OurRuntimeException> s = new Supplier<OurRuntimeException>() {

			@Override
			public OurRuntimeException get() {
				return new OurRuntimeException(null, "id tapilmadi");
			}
		};

		Book book = bookRepository.findById(id).orElseThrow(s);

		if (book.getUserId() == operatorUser.getId()) {
			bookRepository.deleteById(id);

		} else {
			throw new OurRuntimeException(null, "oz kitabini sil");
		}
	}

	public BookResponseDto getBookById(Integer id) {
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			BookResponseDto res = new BookResponseDto();
			res.setId(book.get().getId());
			res.seYear(book.get().getYear());
			res.setAuthor(book.get().getAuthor());
			res.setTitle(book.get().getTitle());
			return res;
		}else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}

	public List<Book> findpagination(Integer begin, Integer length) {

		return bookRepository.pagination(begin, length);
	}

	public List<TestEntity> findView() {

		return viewRepository.findAll();
	}

	public void update(@Valid BookRequestDto dto) {
		if (dto.getId() == null || dto.getId() <= 0) {
			throw new OurRuntimeException(null, "id is wrong");
		}
		Optional<Book> byId = bookRepository.findById(dto.getId());
		if (byId.isPresent()) {
			Book book = byId.get();
			mapper.map(dto, book);
			bookRepository.save(book);
		}else {
			throw new OurRuntimeException(null, "id not found");
		}
	}

	public List<BookResponseModel> convertMovieToResponseModel(List<Book> books) {
		// TODO Auto-generated method stub
		List<BookResponseModel> dtos = new ArrayList<BookResponseModel>();
		for (Book book : books) {
			BookResponseModel dto = new BookResponseModel();
			mapper.map(book, dto);
			dtos.add(dto);
		}
		return dtos;
	}

}