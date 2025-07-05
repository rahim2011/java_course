package az.developia.book_project;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

@SpringBootApplication
public class BookProjectApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper m = new ModelMapper();
		return m;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookProjectApplication.class, args);
	}

}