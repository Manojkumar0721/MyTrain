package com.tutorsdude.mytrain.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tutorsdude.mytrain.dto.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{
    
	@Query("SELECT booking FROM Booking booking WHERE booking.pnr = :pnr")
	public Optional<Booking> findByPnr(@Param("pnr") String pnr);
}
