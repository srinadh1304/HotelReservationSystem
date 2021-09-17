package com.bridgelabz.hotelreservationsystem;
import java.time.LocalDate;

public interface HotelReservationInterface {
	public boolean  addHotel(String name, double rate);
	public Hotel getCheapestHotel(LocalDate date1, LocalDate date2);
}
