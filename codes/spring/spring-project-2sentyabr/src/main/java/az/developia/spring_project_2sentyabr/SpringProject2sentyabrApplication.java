package az.developia.spring_project_2sentyabr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import az.developia.spring_project_2sentyabr.config.Computer;
import az.developia.spring_project_2sentyabr.entity.Book;

@SpringBootApplication
public class SpringProject2sentyabrApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext  r=SpringApplication.run(SpringProject2sentyabrApplication.class, args);
		
		/*Book bean=r.getBean(Book.class);
		System.out.println(bean.getName());
		  
		Computer bean1=r.getBean(Computer.class);
		System.out.println(bean1.getRam());
		
		String[] beanDefinitionNames=r.getBeanDefinitionNames();
		for(String names : beanDefinitionNames) {
			System.out.println(names);
		}*/
	}

}
