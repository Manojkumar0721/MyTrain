package com.tutorsdude.mytrian.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tutorsdude.mytrian.constants.TrainStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "train")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Train {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String trainName;
	private int trainNo;
	private String source;
	private String destination;
	private int totalCapacity;
	private int filled;
	private TrainStatus trainStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "schedule_id", referencedColumnName = "id")
	@JsonManagedReference
	private Schedule schedule;

}
