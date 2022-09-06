package com.fpt.edu.entity;

import java.sql.Time;

public class ShowTime {
	private int id;
	private String name;
	private Time start_time;
	private Time end_time;
	private double price;
	
	public ShowTime() {
		super();
	}
	
	
	
	public ShowTime(String name, Time start_time, Time end_time, double price) {
		super();
		this.name = name;
		this.start_time = start_time;
		this.end_time = end_time;
		this.price = price;
	}
	
	public ShowTime(int id, String name, Time start_time, Time end_time, double price) {
		super();
		this.id = id;
		this.name = name;
		this.start_time = start_time;
		this.end_time = end_time;
		this.price = price;
	}



	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Time getStart_time() {
		return start_time;
	}

	public void setStart_time(Time start_time) {
		this.start_time = start_time;
	}

	public Time getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
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
}
