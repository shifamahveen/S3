package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Student {
	private int id;
	private String name;
	private String batch;
	
	public Student() {
		super();
		System.out.println("Student bean created...");
	}

	public void show() {
		System.out.println("show method..");
	}	
}