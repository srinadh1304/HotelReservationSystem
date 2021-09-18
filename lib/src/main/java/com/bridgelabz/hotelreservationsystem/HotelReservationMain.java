package com.bridgelabz.hotelreservationsystem;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import com.bridgelabz.hotelreservationsystem.HotelReservationException.ExceptionType;
public class HotelReservationMain implements HotelReservationInterface {

	ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
	Hotel hotels;
	public boolean  addHotel(Hotel hotel) {
		hotelList.add(hotel);
		System.out.println(hotel);
		return true;
	}
	@SuppressWarnings("incomplete-switch")
	public Hotel getCheapestHotel(LocalDate startDate, LocalDate endDate,String customerType) {
		try {
			if(customerType.length() == 0)
				throw new HotelReservationException(ExceptionType.ENTERED_EMPTY, "EMPTY values not allowed!!");
			int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate);
			int weekends = 0;
			while (startDate.compareTo(endDate) != 0) {
				switch (DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK))) {
				case SATURDAY:
					++weekends;
					break;
				case SUNDAY:
					++weekends;
					break;
				}
				startDate = startDate.plusDays(1);
			}
			int totalWeekDays = numberOfDays - weekends;
			int totalWeekEnds = weekends;
			final double cheapestPrice = hotelList.stream()
					.mapToDouble(hotel -> ((hotel.getWeekendPrice()*totalWeekEnds) + hotel.getWeekdayPrice()*totalWeekDays))
					.min()
					.orElse(Double.MAX_VALUE);

			ArrayList<Hotel> cheapestHotel = hotelList.stream()
					.filter(hotel -> (hotel.getWeekendPrice()*totalWeekEnds + hotel.getWeekdayPrice()*totalWeekDays) == cheapestPrice)
					.collect(Collectors.toCollection(ArrayList::new));

			return cheapestHotel.get(0);
		}
		catch(NullPointerException e) 
		{
			throw new HotelReservationException(ExceptionType.ENTERED_NULL, "NULL values not allowed!!");
		}	

	}
	@SuppressWarnings("incomplete-switch")
	public Hotel getCheapestAndBestRatedHotel(LocalDate startDate, LocalDate endDate,String customerType) {

		int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate);
		int weekends = 0;
		while (startDate.compareTo(endDate) != 0) {
			switch (DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK))) {
			case SATURDAY:
				++weekends;
				break;
			case SUNDAY:
				++weekends;
				break;
			}
			startDate = startDate.plusDays(1);
		}
		int totalWeekDays = numberOfDays - weekends;
		int totalWeekEnds = weekends;
		if(customerType.equalsIgnoreCase("regular")) {
		
			final double cheapestPrice = hotelList.stream()
					.mapToDouble(hotel -> ((hotel.getWeekendPrice()*totalWeekEnds) + hotel.getWeekdayPrice()*totalWeekDays))
					.min()
					.orElse(Double.MAX_VALUE);
			ArrayList<Hotel> cheapestHotels = hotelList.stream()
					.filter(hotel -> (hotel.getWeekendPrice()*totalWeekEnds + hotel.getWeekdayPrice()*totalWeekDays) == cheapestPrice)
					.collect(Collectors.toCollection(ArrayList::new));
			return cheapestHotels.stream()
					.max((h1,h2) -> h1.getRating()-h2.getRating())
					.orElse(null);
		}
		else {
			final double cheapestPrice = hotelList.stream()
					.mapToDouble(hotel -> ((hotel.getRewardWeekendPrice()*totalWeekEnds) + hotel.getRewardWeekdayPrice()*totalWeekDays))
					.min()
					.orElse(Double.MAX_VALUE);
			ArrayList<Hotel> cheapestHotels = hotelList.stream()
					.filter(hotel -> (hotel.getRewardWeekendPrice()*totalWeekEnds + hotel.getRewardWeekendPrice()*totalWeekDays) == cheapestPrice)
					.collect(Collectors.toCollection(ArrayList::new));
			Hotel hotel= cheapestHotels.stream()
					.max((h1,h2) -> h1.getRating()-h2.getRating())
					.orElse(null);
			
			return hotel;
		}
	}

	public Hotel findBestRatedHotel(LocalDate startDate,LocalDate lastDate)
	{		
		Hotel bestRatedHotel = hotelList.stream()
				.max((h1,h2) -> h1.getRating()-h2.getRating())
				.orElse(null);
		System.out.println("The Best Rated Hotel is : "+bestRatedHotel.getName());
		return bestRatedHotel;
	}

}