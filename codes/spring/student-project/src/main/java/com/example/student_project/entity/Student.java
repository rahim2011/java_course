package com.example.student_project.entity;

import jakarta.persistence.Entity;

@Entity
public class Student {
	Integer ID;
	String username;
	String name;
	String surname;
	Integer age;
    String password;
}
