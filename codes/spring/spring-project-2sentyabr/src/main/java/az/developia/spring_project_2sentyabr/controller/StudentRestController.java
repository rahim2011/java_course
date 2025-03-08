package az.developia.spring_project_2sentyabr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/studentRest")

public class StudentRestController {
@GetMapping
private List<String> showStudentRest() {
	List<String> names=new ArrayList<String>();
	names.add("Alirahim");
	names.add("Murad");
	names.add("Hasan");
	return names;
	
}

@PostMapping(path="/add")
public void addStudent(@Valid  @RequestBody StudentRestController student) {
	System.out.println(student);
	
}



}
