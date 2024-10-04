package com.example.demo;

public class Trig {
	private int id;
	private int angle;
	private String func;
	private double result;
	
	public Trig(int id, int angle, String func, double result) {
		this.id = id;
		this.angle = angle;
		this.func = func;
		this.result = result;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public String getFunc() {
		return func;
	}

	public void setFunc(String func) {
		this.func = func;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

}
