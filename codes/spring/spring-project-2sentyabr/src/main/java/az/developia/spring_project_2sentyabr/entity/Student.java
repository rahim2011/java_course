package az.developia.spring_project_2sentyabr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(min=2,max=40,message="ad min 2,max 40 simvol ola biler.")
private String name;
	@Size(min=2,max=40,message="ad min 2,max 40 simvol ola biler.")
private String surname;


public Student(Integer id,  String name,
		String surname) {
	super();
	this.id = id;
	this.name = name;
	this.surname = surname;
}

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

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", surname=" + surname + "]";
}




}
