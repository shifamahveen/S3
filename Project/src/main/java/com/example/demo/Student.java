package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Student {
	private int id;
	private String name;
	private String batch;
	private Subject sub;
	
	public Subject getSub() {
		return sub;
	}

	// setter based DI
	@Autowired
	public void setSub(Subject sub) {
		this.sub = sub;
	}

	public void show() {
		System.out.println("Student Details: ");
		System.out.println("Student ID: "+ id);
		System.out.println("Student Name: "+ name);
		System.out.println("Student Batch: "+ batch);
		System.out.println("Subject: "+sub);		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public Student() {
		super();
		System.out.println("Student bean created...");
	}
	
}