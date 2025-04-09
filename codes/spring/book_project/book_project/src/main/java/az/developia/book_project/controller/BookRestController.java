package az.developia.book_project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.book_project.dto.BookRequestDto;
import az.developia.book_project.entity.Book;
import az.developia.book_project.exception.OurRuntimeException;
import az.developia.book_project.repository.BookRepository;
import az.developia.book_project.response.BookResponse;
import jakarta.validation.Valid;




@RestController
@RequestMapping(path="/bookrest")
public class BookRestController {
	@Autowired
private BookRepository bookRepository;
	@GetMapping
	private BookResponse showBookRest() {
		BookResponse response=new BookResponse();
		response.setBooks(bookRepository.findAll());
		return response;
		
		
	}
	@PostMapping(path="/add")
	public void addStudent(@Valid  @RequestBody BookRequestDto dto,BindingResult br) throws OurRuntimeException {
		
		if(br.hasErrors()) {
			throw new OurRuntimeException();
		}
		Book s =new Book();
		s.setId(1);
		s.setTitle(dto.getTitle());
		s.setAuthor(dto.getAuthor());
		
		bookRepository.save(s);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer id) throws OurRuntimeException {
		if (id==null || id<=0) {
			throw new OurRuntimeException();
		}
		Optional<Book> byId = bookRepository.findById(id);
		if (byId.isPresent()) {
			bookRepository.deleteById(id);
		}else {
			throw new OurRuntimeException();
		}
		
		return ResponseEntity.ok("Book delete successfully");
	}
	
	@PutMapping(path="/update")
	public void update(@Valid  @RequestBody Book book,BindingResult br) throws OurRuntimeException {
		
		if(br.hasErrors()) {
			throw new OurRuntimeException();
		}
		
		if(book.getId()==null || book.getId()==0) {
			throw new OurRuntimeException();
		}
		
		
		if(bookRepository.findById(book.getId()).isPresent()){
			bookRepository.save(book);
		}
		else {
			throw new OurRuntimeException();
		}
		System.out.println(book);
		
	}

}
