package az.developia.spring_project_2sentyabr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.spring_project_2sentyabr.dto.StudentRequestDto;
import az.developia.spring_project_2sentyabr.entity.Student;
import az.developia.spring_project_2sentyabr.exception.OurRuntimeException;
import az.developia.spring_project_2sentyabr.repository.StudentRepository;
import az.developia.spring_project_2sentyabr.response.StudentResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/studentRest")

public class StudentRestController {
	
	@Autowired
private StudentRepository studentRepository;
@GetMapping
private StudentResponse showStudentRest() {
	StudentResponse response=new StudentResponse();
	response.setStudents(studentRepository.findAll());
	response.setLenght(1.83);
	return response;
	
	
}

@PostMapping(path="/add")
public void addStudent(@Valid  @RequestBody StudentRequestDto dto,BindingResult br) {
	
	if(br.hasErrors()) {
		throw new OurRuntimeException(br,"melumatlarin tamliginda problem var");
	}
	Student s =new Student(null, null, null);
	s.setId(null);
	s.setName(dto.getName());
	s.setSurname(dto.getSurname());
	
	studentRepository.save(s);
}
@PutMapping(path="/update")
public void update(@Valid  @RequestBody Student student,BindingResult br) {
	
	if(br.hasErrors()) {
		throw new OurRuntimeException(br,"melumatlarin tamliginda problem var");
	}
	
	if(student.getId()==null || student.getId()==0) {
		throw new OurRuntimeException(br,"id null ola bilmez");
	}
	
	
	if(studentRepository.findById(student.getId()).isPresent()){
		studentRepository.save(student);
	}
	else {
		throw new OurRuntimeException(null,"id tapilmadi");
	}
	System.out.println(student);
	
}

@DeleteMapping(path = "/{id}")
public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
	//null, 0, not found, found
	if (id==null || id<=0) {
		throw new OurRuntimeException(null, "id mutleqdir");
	}
	Optional<Student> byId = studentRepository.findById(id);
	if (byId.isPresent()) {
		studentRepository.deleteById(id);
	}else {
		throw new OurRuntimeException(null, "id tapilmadi");
	}
	
	return ResponseEntity.ok("Stdudent delete successfully");
}

@GetMapping(path = "/{id}")
public Student getById(@PathVariable Integer id) {
	if(id==null || id<=0) {
		throw new OurRuntimeException(null,"id mutleqdir");
	}
	Optional<Student> byid=studentRepository.findById(id);	
	if(byid.isPresent()) {
		return byid.get();
	}
	else {
		throw new OurRuntimeException(null,"id tapilmadi");
	}
}
}
