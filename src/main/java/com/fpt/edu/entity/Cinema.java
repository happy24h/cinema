package com.fpt.edu.entity;

import java.time.LocalDateTime;

public class Cinema {
	private int id;
	private int idAccount;
	private String name;
	private String address;
	private String intro;
	private int status;
	private LocalDateTime createdAt;
	
	public Cinema() {
		super();
	}

	public Cinema(int idAccount, String name, String address, String intro) {
		super();
		this.idAccount = idAccount;
		this.name = name;
		this.address = address;
		this.intro = intro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
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
