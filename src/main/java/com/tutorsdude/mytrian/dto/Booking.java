package com.tutorsdude.mytrian.dto;

import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int trainNo;
    private int userId;
    private int noOfPassengers;
    
    private String pnr;
    
    @PrePersist
    public void generatePnr() {
        if (this.pnr == null || this.pnr.isEmpty()) {
            this.pnr = generateRandomPnr();
        }
    }
    
    // Method to generate random PNR (6 alphanumeric characters)
    private String generateRandomPnr() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder pnr = new StringBuilder();
        Random random = new Random();
        
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            pnr.append(characters.charAt(index));
        }
        
        return pnr.toString();
    }
    
   

}
