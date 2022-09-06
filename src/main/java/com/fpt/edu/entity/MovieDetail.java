package com.fpt.edu.entity;

public class MovieDetail {
	private int id;
	private int idMovie;
	private int idDetail;
	
	public MovieDetail() {
		super();
	}
	
	public MovieDetail(int idMovie, int idDetail) {
		super();
		this.idMovie = idMovie;
		this.idDetail = idDetail;
	}


	public MovieDetail(int id, int idMovie, int idDetail) {
		super();
		this.id = id;
		this.idMovie = idMovie;
		this.idDetail = idDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	public int getIdDetail() {
		return idDetail;
	}

	public void setIdDetail(int idDetail) {
		this.idDetail = idDetail;
	}
	
	
	
}
