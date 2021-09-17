package com.bridgelabz.hotelreservationsystem;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {
	@Test
	public void givenHotel_Added_ShoulReturnTrue()
	{
		HotelReservationMain hotelReservation = new HotelReservationMain();
		boolean hotel1 = hotelReservation.addHotel("Lakewood",110);
		Assert.assertTrue(hotel1);
		boolean hotel2 = hotelReservation.addHotel("Bridgewood",160);
		Assert.assertTrue(hotel2);
		boolean hotel3 = hotelReservation.addHotel("Ridgewood", 90);
		Assert.assertTrue(hotel3);
	}
}
