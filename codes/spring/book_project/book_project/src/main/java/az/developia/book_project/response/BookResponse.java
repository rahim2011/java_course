package az.developia.book_project.response;

import java.util.List;

import az.developia.book_project.entity.Book;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BookResponse {
private List<Book> books;

}
