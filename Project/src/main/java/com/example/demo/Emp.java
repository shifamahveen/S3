package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Emp {
	private int eid;
	private String ename;
	private Dept dept;
	
	@Autowired
	public Emp (Dept dept) {
		this.dept = dept;
	}
	
	public void show() {
		System.out.println("Emp ID: "+eid+" Employee name: "+ename+" Dept: "+dept);
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
