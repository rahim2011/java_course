package az.developia.spring_project_2sentyabr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import az.developia.spring_project_2sentyabr.entity.Book;

@SpringBootApplication
public class SpringProject2sentyabrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProject2sentyabrApplication.class, args);
		
		Book bean=run.getBean(book.class);
		System.out.println(bean.getName());
		
		String[] beanDefinitionNames=run.getBeanDefinitionNames();
		for(String names : BeanDefinitionNames()) {
			System.out.println(names);
		}
	}

}
