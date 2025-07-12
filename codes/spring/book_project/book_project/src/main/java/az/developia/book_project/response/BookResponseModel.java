package az.developia.book_project.response;


import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter(value = "books")
public class BookResponseModel {
	private Integer Id;
	private String title;
	private String genre;
	private Integer rating;
}