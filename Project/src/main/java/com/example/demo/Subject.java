package com.example.demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Subject {
	@Value("${subject.id}")
	private int sid;
	@Value("${subject.name}")
	private String sname;

	@Override
	public String toString() {
		return "Subject [sid=" + sid + ", sname=" + sname + "]";
	}
	
	public int getSid() {
		return sid;
	}
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
