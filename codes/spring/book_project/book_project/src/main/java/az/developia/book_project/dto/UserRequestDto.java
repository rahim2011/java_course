package az.developia.book_project.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

	@Size(min= 2, max=50, message = "min 2 max 50 simvol olmalidir")
	private String firstName;

	@Size(min= 2, max=50, message = "min 2 max 50 simvol olmalidir")
	private String lastName;
	private String username;
	private String password;
	
	@ValidEmail(message="")
	private String email;
}