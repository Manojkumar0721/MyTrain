package com.tutorsdude.mytrain.service;

import java.util.List;
import java.util.Optional;

import com.tutorsdude.mytrain.dto.Train;

public interface TrainService {
	
	public boolean createTrain(Train train);
	
	public List<Train> getAllTrain();
	
	public Optional<Train> getAllTrainById(int id);
	
	public Train updateTrain(int id,Train trainDetails);
	
	public void deleteTrain(int id);
	
	public Optional<Train> getTrainBySourceAndDestination(String source,String destination);

}
