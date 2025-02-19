package az.developia.spring_project_2sentyabr.config;

public class MyStudent {

}package az.developia.spring_project_2sentyabr.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import az.developia.spring_project_2sentyabr.entity.Computer;
import az.developia.spring_project_2sentyabr.entity.Student;
@Configuration
public class MyConfig {
	
	@Bean
	public Student myStudent2() {
		Student s=new Student();
		s.setId(45);
		s.setName("Fuad");
		s.setSurname("Bayramov");
		return s;
	}
	
	@Bean
	@Primary
	public Computer myComp2() {
		Computer c=new Computer();
		c.setId(123);
		c.setModel("g65");
		return c;
	}
}
