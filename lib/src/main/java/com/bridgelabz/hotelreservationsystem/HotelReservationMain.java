package com.bridgelabz.hotelreservationsystem;

import java.util.ArrayList;

public class HotelReservationMain {
	
	ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
	Hotel hotels;
	public boolean addHotel(String hotelName,int rate)
	{
		hotels=new Hotel(hotelName,rate);
		return this.hotelList.add(hotels);
	}
}