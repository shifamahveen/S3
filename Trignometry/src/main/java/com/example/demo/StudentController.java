package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class StudentController {
	Student s;
	
	//	localhost:8081/students/1
	@PostMapping
	public String create(@RequestBody Student student) {
		this.s = student;
		return "Student Created";
	}
	
	@GetMapping("{id}")
	public Student show(String id) {
		return s;
	}
	
	@PutMapping
	public String update(@RequestBody Student student) {
		this.s = student;
		return "Student Updated";
	}
	
	@DeleteMapping("{id}")
	public String delete(String id) {
		this.s = null;
		return "Student deleted";
	}
	
}
