package com.tutorsdude.mytrain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorsdude.mytrain.dto.Booking;
import com.tutorsdude.mytrain.dto.BookingResponse;
import com.tutorsdude.mytrain.service.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/bookTrain")
    public BookingResponse bookTrain(@RequestParam int trainNo,@RequestParam int noOfPassengers,@RequestParam int userId) {                         
        return bookingService.bookTrain(trainNo, noOfPassengers, userId);
    }
	
	@GetMapping("/getBookingByPnr/{pnr}")
	public Booking getBookingByPnr(@PathVariable String pnr) {
		return bookingService.getBookingByPnr(pnr);
	}
	
	@GetMapping("/getAllBooking")
	public List<Booking> getAllBooking(){
		return bookingService.getAllBooking();
	}

}
