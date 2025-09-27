package com.example.student_project.requestDto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {
	private Integer ID;
	
@NotNull
	private String name;
 @NotNull
	private String surname;
	private String username;
	private String password;
	

}
