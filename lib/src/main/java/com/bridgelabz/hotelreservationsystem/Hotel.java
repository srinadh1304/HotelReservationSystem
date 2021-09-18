package com.bridgelabz.hotelreservationsystem;

public class Hotel {
	private String name;
	private double weekendPrice;
	private double weekdayPrice;
	private double rewardWeekdayPrice;
	private double rewardWeekendPrice;
	
	
	private int rating;


	public Hotel(String name, double weekendPrice, double weekdayPrice, int rating) {
		super();
		this.name = name;
		this.weekendPrice = weekendPrice;
		this.weekdayPrice = weekdayPrice;
		this.rating = rating;
	}
	public Hotel(String name, double weekendPrice, double weekdayPrice, double rewardWeekdayPrice,
			double rewardWeekendPrice, int rating) {
		super();
		this.name = name;
		this.weekendPrice = weekendPrice;
		this.weekdayPrice = weekdayPrice;
		this.rewardWeekdayPrice = rewardWeekdayPrice;
		this.rewardWeekendPrice = rewardWeekendPrice;
		this.rating = rating;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public void setWeekdayPrice(double weekdayPrice) {
		this.weekdayPrice = weekdayPrice;
	}
	
	public double getWeekdayPrice() {
		return this.weekdayPrice;
	}
	
	public double getWeekendPrice() {
		return weekendPrice;
	}

	public void setWeekendPrice(double weekendPrice) {
		this.weekendPrice = weekendPrice;
	}
	
	public double getRewardWeekdayPrice() {
		return rewardWeekdayPrice;
	}
	public void setRewardWeekdayPrice(double rewardWeekdayPrice) {
		this.rewardWeekdayPrice = rewardWeekdayPrice;
	}
	public double getRewardWeekendPrice() {
		return rewardWeekendPrice;
	}
	public void setRewardWeekendPrice(double rewardWeekendPrice) {
		this.rewardWeekendPrice = rewardWeekendPrice;
	}
	public Double getPrice(int numOfWeekdays, int numOfWeekends) {
		return weekdayPrice*numOfWeekdays + weekendPrice*numOfWeekends;
	}
	public double getPriceForRewardCustomers(int numberOfWeekdays, int numberOfWeekends) 
	{
		return rewardWeekdayPrice*numberOfWeekdays +rewardWeekendPrice*numberOfWeekends;
	}
	@Override
	public String toString() {
		return "Hotel Name: "+this.name+" Week day Price: "+this.weekdayPrice+" Week end Price: "+this.weekendPrice+" Rating: "+this.rating; 
	}
}