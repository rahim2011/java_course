package az.developia.book_project.dto;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Movie Request Dto",description = "melumatlarin qebul eden dto")
public class BookRequestDto {
	private Integer id;
	private String title;
	private LocalDate year;
	private String author;
	private Integer userId;

}