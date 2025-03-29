package az.developia.spring_project_2sentyabr.response;

import java.util.List;

import az.developia.spring_project_2sentyabr.entity.Student;

public class StudentResponse {
	private List<Student> students;
	private Double lenght;
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Double getLenght() {
		return lenght;
	}
	public void setLenght(Double lenght) {
		this.lenght = lenght;
	}
	
	
	
	
	
	
}
