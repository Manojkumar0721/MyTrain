package com.tutorsdude.mytrain.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tutorsdude.mytrain.dto.Train;

@Repository
public interface TrainRepo extends JpaRepository<Train, Integer>{
	
	@Query("SELECT train from Train train WHERE train.trainNo = :nm")
	public Train findByTrainNo(@Param("nm") int trainNo);
	
	@Query("SELECT train from Train train WHERE train.source = :nm AND train.destination = :mn")
	public Optional<Train> getTrainBySourceAndDestination(@Param("nm") String source,@Param("mn") String destination);

}
