package com.bridgelabz.hotelreservationsystem;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.stream.Collectors;
public class HotelReservationMain implements HotelReservationInterface {
	
	ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
	Hotel hotels;
	public boolean  addHotel(Hotel hotel) {
		hotelList.add(hotel);
		System.out.println(hotel);
		return true;
	}
	@SuppressWarnings("incomplete-switch")
	public Hotel getCheapestHotel(LocalDate startDate, LocalDate endDate) {
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
	
	

}