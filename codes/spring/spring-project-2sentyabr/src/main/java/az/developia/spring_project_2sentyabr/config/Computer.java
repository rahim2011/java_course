package az.developia.spring_project_2sentyabr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Computer {
private int id;
private String brand;
private int price;
private String color;
private String model;
@Autowired
private Ram Ram;
 

public Computer() {
	this.id=5;
	this.brand="acer";
	this.price=2000;
	this.color="black";
	this.model="aspire";
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}

public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}



public Ram getRam() {
	return Ram;
}
public void setRam(Ram ram) {
	Ram = ram;
}
  


@Override
public String toString() {
	return "Computer [id=" + id + ", brand=" + brand + ", price=" + price + ", color=" + color + ", model=" + model
			+ ", Ram=" + Ram + "]";
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
