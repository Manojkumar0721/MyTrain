package com.tutorsdude.mytrian.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tutorsdude.mytrian.dto.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer>{
    
	@Query("SELECT booking FROM Booking booking WHERE booking.pnr = :pnr")
	public Optional<Booking> findByPnr(@Param("pnr") String pnr);
}
