package com.altimetrik.busreservation.model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.altimetrik.busreservation.entity.BusDetailsEntity;

public class SearchResultModel {
	
	String busNumber;
	
	String operatorName;
	
	String departureTime;
	
	String arrivalTime;
	
	double totalDuration;
	
	double fare;

	public SearchResultModel(String busNumber, String operatorName, String departureTime, String arrivalTime,
			double totalDuration, double fare) {
		super();
		this.busNumber = busNumber;
		this.operatorName = operatorName;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.totalDuration = totalDuration;
		this.fare = fare;
	}

	public SearchResultModel() {
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(double totalDuration) {
		this.totalDuration = totalDuration;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public static List<SearchResultModel> formSearchResultModel(List<BusDetailsEntity> busDetailsList) {
		return busDetailsList.stream().map(busDetails -> {
			SearchResultModel searchResultModel = new SearchResultModel();
			searchResultModel.setBusNumber(busDetails.getBusNumber());
			searchResultModel.setOperatorName(busDetails.getBusOperatorName());
			searchResultModel.setDepartureTime(busDetails.getBusDepartureTime());
			searchResultModel.setArrivalTime(busDetails.getBusArrivalTime());
			searchResultModel.setTotalDuration(busDetails.getTotalDuration());
			searchResultModel.setFare(busDetails.getFare());
			return searchResultModel;
		}).sorted(Comparator.comparing(SearchResultModel::getFare)).collect(Collectors.toList());
	}

}
