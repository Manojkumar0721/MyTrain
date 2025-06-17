package com.tutorsdude.mytrain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorsdude.mytrain.constants.TrainStatus;
import com.tutorsdude.mytrain.dto.Booking;
import com.tutorsdude.mytrain.dto.BookingResponse;
import com.tutorsdude.mytrain.dto.Train;
import com.tutorsdude.mytrain.dto.User;
import com.tutorsdude.mytrain.repo.BookingRepo;
import com.tutorsdude.mytrain.repo.TrainRepo;
import com.tutorsdude.mytrain.repo.UserRepo;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingRepo bookingRepo;
	
	@Autowired
	private TrainRepo trainRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private EmailService emailService;

	@Override
    public BookingResponse bookTrain(int trainNo, int noOfPassengers, int userId) {
	    
	    if (noOfPassengers <= 0) {
	        return new BookingResponse("Number of passengers must be positive", null);
	    }

	    
	    Train train = trainRepo.findByTrainNo(trainNo);
	    if (train == null) {
	        return new BookingResponse("Train not found", null);
	    }

	    Optional<User> userOptional = userRepo.findById(userId);
	    if (userOptional.isEmpty()) {
	        return new BookingResponse("User not found", null);
	    }

	    
	    if (!checkStatus(train.getTrainStatus())) {
	        return new BookingResponse("Train is not available", null);
	    }

	    
	    if (!checkCapacityForBooking(train.getTotalCapacity(), train.getFilled(), noOfPassengers)) {
	        return new BookingResponse("Seats not available", null);
	    }

	    
	    User user = userOptional.get();
	    Booking booking = createBooking(train, user, noOfPassengers);
	    
	    String subject = "Train Booking Conformation";
	    String body = "Hello " + user.getName() + ",\n\n" 
	    		+ "Your booking has been confirmed.\n"
	    		+ "Train Name: " + train.getTrainName() + "\n"
	    		+ "From: " + train.getSource() + "\n"
	    		+ "To: " + train.getDestination() + "\n"
	    		+ "noOfPassengers: " + noOfPassengers + "\n"
	    		+ "Thank you for booking with us!";
	    
	    emailService.sendBookingEmail(user.getEmail(), subject, body);
	    
	    return new BookingResponse("Booking successful", booking);
	}
	
	private Booking createBooking(Train train, User user, int noOfPassengers) {
	    Booking booking = new Booking();
	    booking.setTrainNo(train.getTrainNo());
	    booking.setUserId(user.getId());
	    booking.setNoOfPassengers(noOfPassengers);
	    bookingRepo.save(booking);
	    return booking;
	}

	@Override
	public boolean checkStatus(TrainStatus trainStatus) {
		if (trainStatus.equals(TrainStatus.AVAILABLE)) {
            return true;
        }
        return false;
	}

	@Override
	public boolean checkCapacityForBooking(int totalCapacity, int filled, int noOfPassengers) {
		return (totalCapacity - filled) >= noOfPassengers;
	}

	@Override
	public Booking getBookingByPnr(String pnr) {
		return bookingRepo.findByPnr(pnr).orElseThrow(() -> new RuntimeException("Booking not found with PNR: " + pnr));
	}

	@Override
	public List<Booking> getAllBooking() {
		return bookingRepo.findAll();
	}
	
	
	
	

}
