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
		Hotel firstHotel  = new Hotel("Lakewood",110,90,80,80,3);
		Hotel secondHotel  = new Hotel("Bridgewood",150,50,110,80,4);
		Hotel thirdHotel  = new Hotel("Ridgewood",220,150,100,40,5);
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
		Hotel hotel = hotels.getCheapestHotel(startDate, endDate,"regular");
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
		Hotel cheapestHotel = hotels.getCheapestHotel(startDate,lastDate,"regular");
		assertEquals("Bridgewood",cheapestHotel.getName());
	}
	@Test
	public void givenDateRange_find_CheapestAndBestRatedHotel() {
		LocalDate startDate = LocalDate.of(2021, 3, 19);
		LocalDate lastDate = LocalDate.of(2021, 3, 24);
		Hotel hotel = hotels.getCheapestAndBestRatedHotel(startDate,lastDate,"regular");
		assertEquals("Bridgewood",hotel.getName());
		assertEquals(4,hotel.getRating());
	}
	@Test
	public void givenHotelDetails_ShouldReturn_HotelWithBestRating()
	{
		LocalDate startDate = LocalDate.of(2021, 3, 19);
		LocalDate lastDate = LocalDate.of(2021, 3, 24);
		Hotel cheapestHotel = hotels.findBestRatedHotel(startDate, lastDate);
		assertEquals("Ridgewood",cheapestHotel.getName());
	}
	@Test
	public void givenRewardPrices_Added_ShoulReturnTrue()
	{
		HotelReservationMain hotelReservation = new HotelReservationMain();
		Hotel hotelForTest =new Hotel("Lakewood",110,90,80,80,3);
		boolean hotel1 = hotelReservation.addHotel(hotelForTest);
		Assert.assertTrue(hotel1);

	}
	@Test
	public void givenHotelDetails_whenCustomerTypeIsReward_ShouldReturnCheapestHotelWithBestRating()
	{
		LocalDate startDate = LocalDate.of(2021, 3, 19);
		LocalDate lastDate = LocalDate.of(2021, 3, 24);
		try 
		{
			Hotel cheapestHotel = hotels.getCheapestAndBestRatedHotel(startDate, lastDate,"reward");
			assertEquals("Bridgewood", cheapestHotel.getName());
		}
		catch(HotelReservationException e) 
		{
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void givenHotelDetails_whenStartDateIsNull_ShouldReturnExceptionMessgae()
	{
		LocalDate startDate = LocalDate.of(2021, 3, 19);
		LocalDate lastDate = LocalDate.of(2021, 3, 24);
		try 
		{
			Hotel cheapestHotel = hotels.getCheapestAndBestRatedHotel(null, lastDate,"reward");
			
		}
		catch(HotelReservationException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenHotelDetails_whenLastDateIsNull_ShouldReturnExceptionMessgae()
	{
		LocalDate startDate = LocalDate.of(2021, 3, 19);
		LocalDate lastDate = LocalDate.of(2021, 3, 24);
		try 
		{
			Hotel cheapestHotel = hotels.getCheapestAndBestRatedHotel(startDate, null ,"reward");
			
		}
		catch(HotelReservationException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void givenHotelDetails_whenStringIsEmpty_ShouldReturnExceptionMessgae()
	{
		LocalDate startDate = LocalDate.of(2021, 3, 19);
		LocalDate lastDate = LocalDate.of(2021, 3, 24);
		try 
		{
			Hotel cheapestHotel = hotels.getCheapestAndBestRatedHotel(startDate, lastDate,"");
		}
		catch(HotelReservationException e) 
		{
			System.out.println(e.getMessage());
		}
	}

}
