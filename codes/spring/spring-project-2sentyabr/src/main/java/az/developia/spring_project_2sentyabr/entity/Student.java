package az.developia.spring_project_2sentyabr.entity;

import jakarta.validation.constraints.Size;

public class Student {
	private Integer id;
	@Size(min=2,max=40,message="ad min 2,max 40 simvol ola biler.")
private String name;
private String surname;

public Student(Integer id, @Size(min = 2, max = 40, message = "ad min 2,max 40 simvol ola biler.") String name,
		String surname) {
	super();
	this.id = id;
	this.name = name;
	this.surname = surname;
}

public int getId() {
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

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", surname=" + surname + "]";
}




}
