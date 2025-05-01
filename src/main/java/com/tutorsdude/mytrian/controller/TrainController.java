package com.tutorsdude.mytrian.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorsdude.mytrian.dto.Train;
import com.tutorsdude.mytrian.service.TrainService;


@RestController
@RequestMapping("/api/train")
public class TrainController {
	
	@Autowired
	private TrainService service;
	
	@PostMapping
	public String createTrain(@RequestBody Train train) {
		if(train!=null) {
			service.createTrain(train);
			return "Train added successfully";
		}
		return "Train not added try again";
	}
	
	@GetMapping
	public List<Train> getAllTrain(){
		return service.getAllTrain();
	}
	
	@GetMapping("/{id}")
	public Optional<Train> getTrainById(@PathVariable int id){
		return service.getAllTrainById(id);
	}
	
	@PutMapping("/{id}")
	public Train updateTrain(@PathVariable int id,@RequestBody Train trainDetails) {
		return service.updateTrain(id, trainDetails);
	}
	
	@DeleteMapping("/{id}")
	public String deleteTrain(@PathVariable int id) {
		if(id>0) {
			service.deleteTrain(id);
			return "Train Deleted successfully";
		}
		return "Train not deleted try again";
	}

}
