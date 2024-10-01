package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Emp {
	@Id
	private int eid;
	private String ename;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + "]";
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
}
