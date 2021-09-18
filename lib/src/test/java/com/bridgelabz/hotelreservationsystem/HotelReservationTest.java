package com.bridgelabz.hotelreservationsystem;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelReservationTest {
	HotelReservationMain hotels;
	@Before
	public void initialize() {
		hotels = new HotelReservationMain();
		Hotel firstHotel  = new Hotel("Lakewood",110,90,3);
		Hotel secondHotel  = new Hotel("Bridgewood",150,50,4);
		Hotel thirdHotel  = new Hotel("Ridgewood",220,150,5);
		hotels.addHotel(firstHotel);
		hotels.addHotel(secondHotel);
		hotels.addHotel(thirdHotel);
		
	}
	@Test
	public void givenHotel_Added_ShoulReturnTrue()
	{
		HotelReservationMain hotelReservation = new HotelReservationMain();
		Hotel hotelForTest =new Hotel("Lakewood",110,90,3);
		boolean hotel1 = hotelReservation.addHotel(hotelForTest);
		Assert.assertTrue(hotel1);
		
	}
	
	@Test
	public void given_Start_End_Date_ShouldReturn_CheapestPrice() throws Exception{
		LocalDate startDate = LocalDate.of(2021, 9, 10);
		LocalDate endDate = LocalDate.of(2021, 9, 11);
		Hotel hotel = hotels.getCheapestHotel(startDate, endDate);
		assertEquals("Bridgewood", hotel.getName());
	}
	@Test
	public void given_Weekday_Weekend_Price_Should_Add_hotel(){
		HotelReservationMain hotelReservation = new HotelReservationMain();
		Hotel hotelForTest =new Hotel("Lakewood",110,90,3);
		boolean hotel1 = hotelReservation.addHotel(hotelForTest);
		Assert.assertTrue(hotel1);
	}
	@Test
	public void givenWeekdaysAndWeekends_WhenCorrect_ShoulReturnProperHotelName()
	{
		LocalDate startDate = LocalDate.of(2021, 3, 19);
	    LocalDate lastDate = LocalDate.of(2021, 3, 24);
		Hotel cheapestHotel = hotels.getCheapestHotel(startDate,lastDate);
		assertEquals("Bridgewood",cheapestHotel.getName());
	}
}
