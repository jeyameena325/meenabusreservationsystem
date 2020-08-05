package com.altimetrik.busreservation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bus_details")
public class BusDetailsEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "bus_number")
	private String busNumber;
	
	@Column(name = "bus_operator_name")
	private String busOperatorName;

	@Column(name = "source_city")
	private String sourceCity;

	@Column(name = "destination_city")
	private String destinationCity;

	@Temporal(TemporalType.DATE)
	@Column(name = "travel_date")
	private Date travelDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "return_date")
	private Date returnDate;

	@Column(name = "bus_arrival_time")
	private String busArrivalTime;
	
	@Column(name = "bus_departure_time")
	private String busDepartureTime;

	@Column(name = "total_duration")
	private Double totalDuration;

	@Column(name = "fare")
	private Double fare;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusOperatorName() {
		return busOperatorName;
	}

	public void setBusOperatorName(String busOperatorName) {
		this.busOperatorName = busOperatorName;
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

	public String getBusArrivalTime() {
		return busArrivalTime;
	}

	public void setBusArrivalTime(String busArrivalTime) {
		this.busArrivalTime = busArrivalTime;
	}

	public String getBusDepartureTime() {
		return busDepartureTime;
	}

	public void setBusDepartureTime(String busDepartureTime) {
		this.busDepartureTime = busDepartureTime;
	}

	public Double getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(Double totalDuration) {
		this.totalDuration = totalDuration;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	
}
