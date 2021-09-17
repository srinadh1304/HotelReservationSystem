package com.bridgelabz.hotelreservationsystem;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {
	@Test
	public void givenHotel_Added_ShoulReturnTrue()
	{
		HotelReservationMain hotelReservation = new HotelReservationMain();
		boolean hotel1 = hotelReservation.addHotel("Lakewood",110.0);
		Assert.assertTrue(hotel1);
		boolean hotel2 = hotelReservation.addHotel("Bridgewood",160.0);
		Assert.assertTrue(hotel2);
		boolean hotel3 = hotelReservation.addHotel("Ridgewood", 90.0);
		Assert.assertTrue(hotel3);
	}
	
	@Test
	public void given_Start_End_Date_ShouldReturn_CheapestPrice() throws Exception{
		HotelReservationMain hotelReservation = new HotelReservationMain();
		hotelReservation.addHotel("Bridgewood", 100);
		hotelReservation.addHotel("Lakewood", 200);
		LocalDate startDate = LocalDate.of(2021, 9, 10);
		LocalDate endDate = LocalDate.of(2021, 9, 11);
		Hotel hotel = hotelReservation.getCheapestHotel(startDate, endDate);
		assertEquals("Bridgewood", hotel.getName());
	}
}
