package az.developia.spring_project_2sentyabr.entity;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Home {
private Integer id;
private String adreess;
private String color;

public Home() {
	super();
	this.id = 5;
	this.adreess = "Nerimanov";
	this.color = "blue";
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getAdreess() {
	return adreess;
}

public void setAdreess(String adreess) {
	this.adreess = adreess;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

@PostConstruct
public void init() {
	System.out.println("init method");
}

@PreDestroy
public void destroy() {
	System.out.println("destroy method");
}

}


