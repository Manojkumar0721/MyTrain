package com.tutorsdude.mytrian.service;

import java.util.List;

import com.tutorsdude.mytrian.constants.TrainStatus;
import com.tutorsdude.mytrian.dto.Booking;
import com.tutorsdude.mytrian.dto.BookingResponse;

public interface BookingService {
	
	public BookingResponse bookTrain(int trainNo, int noOfPassengers, int userId);
	
	public boolean checkStatus(TrainStatus trainStatus);
	
	public boolean checkCapacityForBooking(int totalCapacity, int filled, int noOfPassengers);
	
	public Booking getBookingByPnr(String pnr);
	
	public List<Booking> getAllBooking();

}
