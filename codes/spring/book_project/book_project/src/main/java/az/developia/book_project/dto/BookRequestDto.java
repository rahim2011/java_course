package az.developia.book_project.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class BookRequestDto {
	private Integer id;
	
	@Size(min=2,max=40,message="ad min 2,max 40 simvol ola biler.")
private String title;
	@Size(min=2,max=40,message="ad min 2,max 40 simvol ola biler.")
private String author;
	@Past
	private LocalDate year;


}
