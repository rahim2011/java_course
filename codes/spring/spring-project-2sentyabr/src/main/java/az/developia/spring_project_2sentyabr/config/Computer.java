package az.developia.spring_project_2sentyabr.config;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Computer {
private int id;
private String brand;
private int price;
private String color;


public Computer() {
	this.id=5;
	this.brand="asus";
	this.price=2000;
	this.color="black";
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
@Override
public String toString() {
	return "Computer [id=" + id + ", brand=" + brand + ", price=" + price + ", color=" + color + "]";
}
public Computer(int id, String brand, int price, String color) {
	super();
	this.id = id;
	this.brand = brand;
	this.price = price;
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
