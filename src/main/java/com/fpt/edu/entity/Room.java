package com.fpt.edu.entity;

import java.time.LocalDateTime;

public class Room {
	private int id;
	private String name;
	private int num;
	private int idCinema;
	private int idTypeRoom;
	private int status;
	private LocalDateTime createdAt;
	
	public Room() {
		super();
	}
	
	
	
	public Room(int id, String name, int num, int idCinema, int idTypeRoom, int status, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
		this.idCinema = idCinema;
		this.idTypeRoom = idTypeRoom;
		this.status = status;
		this.createdAt = createdAt;
	}



	public Room(String name, int num, int idCinema, int idTypeRoom) {
		super();
		this.name = name;
		this.num = num;
		this.idCinema = idCinema;
		this.idTypeRoom = idTypeRoom;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getIdCinema() {
		return idCinema;
	}

	public void setIdCinema(int idCinema) {
		this.idCinema = idCinema;
	}

	public int getIdTypeRoom() {
		return idTypeRoom;
	}

	public void setIdTypeRoom(int idTypeRoom) {
		this.idTypeRoom = idTypeRoom;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
