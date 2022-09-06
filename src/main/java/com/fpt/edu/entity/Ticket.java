package com.fpt.edu.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Ticket {
	private int id;
	private int idMovieDetail;
	private int idShowTime;
	private double price;
	private int status;
	private Date dateStart;
	private LocalDateTime createdAt;

	public Ticket() {
		super();
	}
	
	

	public Ticket(int idShowTime, Date dateStart ) {
		super();
		this.idShowTime = idShowTime;
		this.dateStart = dateStart;
	}

	public Ticket(int id, int idMovieDetail, int idShowTime, double price, int status, Date dateStart ,LocalDateTime createdAt) {
		super();
		this.id = id;
		this.idMovieDetail = idMovieDetail;
		this.idShowTime = idShowTime;
		this.price = price;
		this.status = status;
		this.dateStart = dateStart;
		this.createdAt = createdAt;
	}


	


	public Date getDateStart() {
		return dateStart;
	}



	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMovieDetail() {
		return idMovieDetail;
	}

	public void setIdMovieDetail(int idMovieDetail) {
		this.idMovieDetail = idMovieDetail;
	}

	public int getIdShowTime() {
		return idShowTime;
	}

	public void setIdShowTime(int idShowTime) {
		this.idShowTime = idShowTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
