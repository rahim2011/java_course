package az.developia.spring_project_2sentyabr.config;

import org.springframework.stereotype.Component;
@Component(value = "myComp1")
public class Computer {
	private Integer id;
	private String model;
	
	public Computer() {
		this.id=32;
		this.model="Aspiro";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "Computer [id=" + id + ", model=" + model + "]";
	}
	
	
}
