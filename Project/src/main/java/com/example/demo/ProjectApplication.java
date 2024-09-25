package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(ProjectApplication.class, args);
		
		Emp emp = app.getBean(Emp.class);
		emp.setEid(43);
		emp.setEname("Alex");
		
		Dept dept = app.getBean(Dept.class);
		dept.setDeptno(10);
		dept.setDname("Research");
		
		emp.show();
	}
}