package az.developia.spring_project_2sentyabr.config;

import org.springframework.stereotype.Component;

@Component(value ="ComputerRam")

public class Ram {
private Integer speed;
private String model;
public Ram() {
	super();
	this.speed = 12;
	this.model = "core";
}


public int getSpeed() {
	return speed;
}
public void setSpeed(int speed) {
	this.speed = speed;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}


@Override
public String toString() {
	return "Ram [speed=" + speed + ", model=" + model + "]";
}
 


}
