package com.bridgelabz.hotelreservationsystem;

public class Hotel {
	private String name;
	private int rate;
	
	public Hotel(String hotelName, int rate) {
		this.name=hotelName;
		this.rate=rate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
}
