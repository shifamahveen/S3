package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(ProjectApplication.class, args);
		
//		Student s1 = app.getBean(Student.class);
//		s1.show();
//		
//		Student s2 = app.getBean(Student.class);
//		s1.show();
//		Student s1 = new Student(); // plain old java object POJO
//		s1.show();
	}
}