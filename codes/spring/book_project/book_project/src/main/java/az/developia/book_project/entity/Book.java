package az.developia.book_project.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
	private Integer id;
	private String title;
	private String author;
	private LocalDate year;

	
}




