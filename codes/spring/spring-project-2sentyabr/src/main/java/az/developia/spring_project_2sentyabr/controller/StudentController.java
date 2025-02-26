package az.developia.spring_project_2sentyabr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
@GetMapping(path="/telebeler")
public String showStudent() {
	return "students";
	
}
}
