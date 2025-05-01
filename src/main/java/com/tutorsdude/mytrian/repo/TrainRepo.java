package com.tutorsdude.mytrian.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tutorsdude.mytrian.dto.Train;

@Repository
public interface TrainRepo extends JpaRepository<Train, Integer>{
	
	@Query("SELECT train from Train train WHERE train.trainNo = :nm")
	public Train findByTrainNo(@Param("nm") int trainNo);

}
