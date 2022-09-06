package com.fpt.edu.entity;

public class TypeRoom {
	private int id;
	private String name;
	public TypeRoom() {
		super();
	}
	
	
	public TypeRoom(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
