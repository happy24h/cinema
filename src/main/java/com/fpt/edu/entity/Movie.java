package com.fpt.edu.entity;

import java.time.LocalDateTime;

public class Movie {
	private int id;
	private String name;
	private String link;
	private int year;
	private int idTypeMovie;
	private String description;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private int status;
	private LocalDateTime createdAt;
	
	public Movie() {}
	
	public Movie(String name,String link, int year, int idTypeMovie, String description, LocalDateTime startTime,
			LocalDateTime endTime) {
		super();
		this.name = name;
		this.link = link;
		this.year = year;
		this.idTypeMovie = idTypeMovie;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	

	public Movie(int id, String name,String link, int year, int idTypeMovie, String description, LocalDateTime startTime,
			LocalDateTime endTime, int status, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.year = year;
		this.idTypeMovie = idTypeMovie;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		this.createdAt = createdAt;
	}
	
	

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getIdTypeMovie() {
		return idTypeMovie;
	}

	public void setIdTypeMovie(int idTypeMovie) {
		this.idTypeMovie = idTypeMovie;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
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
