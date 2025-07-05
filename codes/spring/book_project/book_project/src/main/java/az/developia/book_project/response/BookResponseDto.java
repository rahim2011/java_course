package az.developia.book_project.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
	private Integer id;
	private String title;
	private String author;
	private LocalDate year;
	private Integer userId;
}
