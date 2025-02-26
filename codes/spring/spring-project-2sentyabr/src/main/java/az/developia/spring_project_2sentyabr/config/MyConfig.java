package az.developia.spring_project_2sentyabr.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyConfig {
	
	@Bean
	@Primary
	public Computer myComp2() {
		Computer c=new Computer();
		c.setId(1);
		c.setModel("g65");
		return c;
	}
	
	public Ram ram() {
		Ram rm=new Ram();
		rm.setSpeed(12);
		rm.setModel("core");
		return rm;
	}
}