package az.developia.spring_project_2sentyabr.entity;

public class Book {
private Integer id;
private String name;
private Double price;
private Integer pageCount;
public Book() {
	this.id=1;
	this.name="Harry Potter";
	this.price=14.0;
	this.pageCount=342;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public Integer getPageCount() {
	return pageCount;
}
public void setPageCount(Integer pageCount) {
	this.pageCount = pageCount;
}


}
