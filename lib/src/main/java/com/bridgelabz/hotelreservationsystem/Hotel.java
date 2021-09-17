package com.bridgelabz.hotelreservationsystem;

public class Hotel {
	private String name;
	private Double rate;
	
	public Hotel(String hotelName, Double rate) {
		this.name=hotelName;
		this.rate=rate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Double getPrice(int numOfDays) {
		return rate*numOfDays;
	}
}
