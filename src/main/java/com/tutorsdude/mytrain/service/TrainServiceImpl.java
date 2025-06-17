package com.tutorsdude.mytrain.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorsdude.mytrain.dto.Train;
import com.tutorsdude.mytrain.repo.TrainRepo;



@Service
public class TrainServiceImpl implements TrainService{
	
	@Autowired
	private TrainRepo trainRepo;

	@Override
	public boolean createTrain(Train train) {
		if(train!=null) {
			 trainRepo.save(train);
			 return true;
		}
		return false;
	}
		

	@Override
	public List<Train> getAllTrain() {
		return trainRepo.findAll();
	}

	@Override
	public Optional<Train> getAllTrainById(int id) {
		if(id>0) {
			return trainRepo.findById(id);
		}
		return Optional.empty();
	}

	@Override
	public Train updateTrain(int id, Train trainDetails) {
		Optional<Train> optionalTrain = trainRepo.findById(id);
		
		if(optionalTrain.isPresent()) {
			Train train = optionalTrain.get();
			train.setId(trainDetails.getId());
			train.setTrainName(trainDetails.getTrainName());
			train.setTrainNo(trainDetails.getTrainNo());
			train.setSource(trainDetails.getSource());
			train.setDestination(trainDetails.getDestination());
			train.setTotalCapacity(trainDetails.getTotalCapacity());
			return trainRepo.save(train);
		}else {
			throw new RuntimeException("Trian with ID" + id + "not Found.");
		}
		
	}

	@Override
	public void deleteTrain(int id) {
		trainRepo.deleteById(id);
	}


	@Override
	public Optional<Train> getTrainBySourceAndDestination(String source, String destination) {
		if(source!=null || destination!=null) {
			return trainRepo.getTrainBySourceAndDestination(source, destination);
		}
		return null;
	}

}
