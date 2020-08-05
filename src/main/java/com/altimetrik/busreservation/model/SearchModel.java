package com.altimetrik.busreservation.model;

import java.util.Date;

public class SearchModel {
	
	String sourceCity;
	
	String destinationCity;
	
	Date travelDate;
	
	Date returnDate;
	
	public SearchModel() {
		super();
	}

	public SearchModel(String sourceCity, String destinationCity, Date travelDate, Date returnDate) {
		super();
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.travelDate = travelDate;
		this.returnDate = returnDate;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

}
