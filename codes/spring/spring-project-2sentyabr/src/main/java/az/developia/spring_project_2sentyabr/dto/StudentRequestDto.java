package az.developia.spring_project_2sentyabr.dto;

import jakarta.validation.constraints.Size;

public class StudentRequestDto {
	private Integer id;
	
	@Size(min=2,max=40,message="ad min 2,max 40 simvol ola biler.")
private String name;
	@Size(min=2,max=40,message="ad min 2,max 40 simvol ola biler.")
private String surname;
	
	private String username;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	


}
