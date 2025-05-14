package az.developia.book_project.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.book_project.dto.BookRequestDto;
import az.developia.book_project.response.BookResponse;
import az.developia.book_project.service.BookService;




@RestController
@RequestMapping(path = "/movies")
@CrossOrigin(origins = "*")
public class BookRestController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public String getBook() {
		return "get book";
	}

	@PostMapping(path = "/add")
	public void create(@RequestBody BookRequestDto dto) {
      bookService.add(dto);
	}

	@GetMapping(path = "/getAll")
	public BookResponse getAll() {
		return bookService.getAll();
	}
	
	@GetMapping(path = "/title")
	public List<String> getBookTitles(){
		return bookService.getBookTitle();
	} 
	
	@DeleteMapping(path = "/{id}")
	public void deleteBook(@PathVariable Integer id) {
		bookService.delete(id);
	}
	
}
