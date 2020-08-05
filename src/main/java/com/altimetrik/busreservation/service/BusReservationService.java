package com.altimetrik.busreservation.service;

import org.springframework.stereotype.Service;

import com.altimetrik.busreservation.exception.ResourceNotFoundException;
import com.altimetrik.busreservation.model.BookingStatusModel;
import com.altimetrik.busreservation.model.SearchModel;
import com.altimetrik.busreservation.model.SearchResultListModel;
import com.altimetrik.busreservation.model.SeatAvailabilityModel;
import com.altimetrik.busreservation.model.SortModel;
import com.altimetrik.busreservation.model.TicketBookingModel;

@Service
public interface BusReservationService {

	public SearchResultListModel getSortResult(SortModel sortModel);

	public SearchResultListModel findAll();

	public SearchResultListModel getSearchResult(SearchModel searchModel);

	public SeatAvailabilityModel checkAvailability(String busNumber);

	public BookingStatusModel bookTicket(TicketBookingModel ticketBookingModel);

}
