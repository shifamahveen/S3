package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(ProjectApplication.class, args);
		
		Student s = app.getBean(Student.class);
		s.setId(1001);
		s.setName("Alex");
		s.setBatch("S3");
		
		Subject sub = app.getBean(Subject.class);
		sub.setSid(11);
		sub.setSname("Springboot");
		
		s.show();
	}
}