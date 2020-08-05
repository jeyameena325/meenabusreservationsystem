package com.altimetrik.busreservation.model;

import java.util.List;

public class SeatAvailabilityModel {
	
	int totalSeats;
	
	int availableSeats;
	
	List<String> availableSeatNumberList;
	
	int unAvailableSeats;
	
	List<String> unAvailableSeatNumberList;

	public SeatAvailabilityModel(int totalSeats, int availableSeats, List<String> availableSeatNumberList,
			int unAvailableSeats, List<String> unAvailableSeatNumberList) {
		super();
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.availableSeatNumberList = availableSeatNumberList;
		this.unAvailableSeats = unAvailableSeats;
		this.unAvailableSeatNumberList = unAvailableSeatNumberList;
	}

	public SeatAvailabilityModel() {
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getUnAvailableSeats() {
		return unAvailableSeats;
	}

	public void setUnAvailableSeats(int unAvailableSeats) {
		this.unAvailableSeats = unAvailableSeats;
	}

	public List<String> getAvailableSeatNumberList() {
		return availableSeatNumberList;
	}

	public void setAvailableSeatNumberList(List<String> availableSeatNumberList) {
		this.availableSeatNumberList = availableSeatNumberList;
	}

	public List<String> getUnAvailableSeatNumberList() {
		return unAvailableSeatNumberList;
	}

	public void setUnAvailableSeatNumberList(List<String> unAvailableSeatNumberList) {
		this.unAvailableSeatNumberList = unAvailableSeatNumberList;
	}

}
