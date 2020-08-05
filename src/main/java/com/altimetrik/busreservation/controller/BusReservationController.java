package com.altimetrik.busreservation.controller;


import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.busreservation.exception.ResourceNotFoundException;
import com.altimetrik.busreservation.model.BookingStatusModel;
import com.altimetrik.busreservation.model.SearchModel;
import com.altimetrik.busreservation.model.SearchResultListModel;
import com.altimetrik.busreservation.model.SeatAvailabilityModel;
import com.altimetrik.busreservation.model.SortModel;
import com.altimetrik.busreservation.model.TicketBookingModel;
import com.altimetrik.busreservation.service.BusReservationService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/service")
public class BusReservationController {

		protected static Logger logger = LoggerFactory.getLogger(BusReservationController.class.getName());

		@Autowired
		private BusReservationService busReservationService;

		@GetMapping(value = "/")
		@ApiOperation(value = "Get all bus details", notes = "Get all information regarding available buses ", response = SearchResultListModel.class)
		public SearchResultListModel findAll() {
			return busReservationService.findAll();
		}

		@GetMapping(value = "/search")
		public SearchResultListModel search(@RequestBody SearchModel searchModel) throws ResourceNotFoundException {
			SearchResultListModel searchResultListModel = new SearchResultListModel();
			if (Objects.nonNull(searchModel.getSourceCity()) && Objects.nonNull(searchModel.getDestinationCity())
					&& Objects.nonNull(searchModel.getTravelDate())) {
				searchResultListModel = busReservationService.getSearchResult(searchModel);
			} else {
				throw new ResourceNotFoundException("Required Param Missing");
			}
			return searchResultListModel;
		}
		
		@GetMapping(value = "/sort")
		public SearchResultListModel sort(@RequestBody SortModel sortModel) {
			return busReservationService.getSortResult(sortModel);
		}

		@GetMapping(value = "/checkAvailability/{busNumber}")
		public SeatAvailabilityModel checkAvailability(@PathVariable(value = "busNumber") String busNumber) {
			return busReservationService.checkAvailability(busNumber);
		}

		@RequestMapping(value = "/bookTicket")
		public BookingStatusModel bookTicket(@RequestBody TicketBookingModel ticketBookingModel) {
			return busReservationService.bookTicket(ticketBookingModel);
		}

}
