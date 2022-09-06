package com.fpt.edu.entity;


public class Refund {
	private int id;
	private String timeRefund;
	private Double percent;
	public Refund() {
		super();
	}
	
	public Refund(int id, String timeRefund, Double percent) {
		super();
		this.id = id;
		this.timeRefund = timeRefund;
		this.percent = percent;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTimeRefund() {
		return timeRefund;
	}
	public void setTimeRefund(String timeRefund) {
		this.timeRefund = timeRefund;
	}
	public Double getPercent() {
		return percent;
	}
	public void setPercent(Double percent) {
		this.percent = percent;
	}
	
}
