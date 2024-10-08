package com.example.demo;

public class Student {
	private int id;
	private String name;
	private String batch;
	
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

	public Student(int id, String name, String batch) {
		super();
		this.id = id;
		this.name = name;
		this.batch = batch;
	}
	
	
}
