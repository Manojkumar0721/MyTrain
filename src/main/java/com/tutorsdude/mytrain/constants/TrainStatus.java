package com.tutorsdude.mytrain.constants;


public enum TrainStatus {
	
	AVAILABLE("available"),CANCELLED("cancelled"),DEPARTED("departed");
	
	public String status;
	
	TrainStatus(String status){
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
