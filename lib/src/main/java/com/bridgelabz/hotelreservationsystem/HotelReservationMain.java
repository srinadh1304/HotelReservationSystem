package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
public class HotelReservationMain implements HotelReservationInterface {
	
	ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
	Hotel hotels;
	@Override
	public boolean addHotel(String name, double rate) {
		hotels=new Hotel(name,rate);
		return this.hotelList.add(hotels);
	}
	public Hotel getCheapestHotel(LocalDate date1, LocalDate date2) {
		Period period = Period.between(date1, date2);
		int numOfDays = period.getDays();
		return hotelList.stream().min((h1,h2) -> h1.getPrice(numOfDays).compareTo(h2.getPrice(numOfDays))).orElse(null);
	}
	
	

}