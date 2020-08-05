package com.altimetrik.busreservation.serviceimpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.altimetrik.busreservation.entity.BusDetailsEntity;
import com.altimetrik.busreservation.entity.SeatReservationDetailsEntity;
import com.altimetrik.busreservation.enums.SortOrderEnum;
import com.altimetrik.busreservation.exception.ResourceNotFoundException;
import com.altimetrik.busreservation.model.BookingStatusModel;
import com.altimetrik.busreservation.model.SearchModel;
import com.altimetrik.busreservation.model.SearchResultListModel;
import com.altimetrik.busreservation.model.SearchResultModel;
import com.altimetrik.busreservation.model.SeatAvailabilityModel;
import com.altimetrik.busreservation.model.SortModel;
import com.altimetrik.busreservation.model.TicketBookingModel;
import com.altimetrik.busreservation.repository.BusDetailsRepository;
import com.altimetrik.busreservation.repository.SeatReservationDetailsRepository;
import com.altimetrik.busreservation.service.BusReservationService;

@Service
public class BusReservationServiceImpl implements BusReservationService {
	
	@Autowired
	BusDetailsRepository busDetailsRepository;
	
	@Autowired
	SeatReservationDetailsRepository seatReservationDetailsRepository;

	@Override
	public SearchResultListModel getSortResult(SortModel sortModel) {
		List<Long> busIdList = sortModel.getBusIdList();
		List<BusDetailsEntity> busDetailsEntityList = busDetailsRepository.findAllById(busIdList);
		List<SearchResultModel> searchResultModelList = SearchResultModel.formSearchResultModel(busDetailsEntityList);
		boolean sortOrder = sortModel.getSortOrder();
		switch (sortModel.getSortColumn()) {
		case "operator_name":
			if (sortOrder == SortOrderEnum.ASCENDING.getValue()) {
				searchResultModelList = searchResultModelList.stream()
						.sorted(Comparator.comparing(SearchResultModel::getOperatorName)).collect(Collectors.toList());
			} else {
				searchResultModelList = searchResultModelList.stream()
						.sorted(Comparator.comparing(SearchResultModel::getOperatorName).reversed())
						.collect(Collectors.toList());
			}
			break;
		case "departure_time":
			if (sortOrder == SortOrderEnum.ASCENDING.getValue()) {
				searchResultModelList = searchResultModelList.stream()
						.sorted(Comparator.comparing(SearchResultModel::getDepartureTime)).collect(Collectors.toList());
			} else {
				searchResultModelList = searchResultModelList.stream()
						.sorted(Comparator.comparing(SearchResultModel::getDepartureTime).reversed())
						.collect(Collectors.toList());
			}
			break;
		case "arrival_time":
			if (sortOrder == SortOrderEnum.ASCENDING.getValue()) {
				searchResultModelList = searchResultModelList.stream()
						.sorted(Comparator.comparing(SearchResultModel::getArrivalTime)).collect(Collectors.toList());
			} else {
				searchResultModelList = searchResultModelList.stream()
						.sorted(Comparator.comparing(SearchResultModel::getArrivalTime).reversed())
						.collect(Collectors.toList());
			}
			break;
		case "duration":
			if (sortOrder == SortOrderEnum.ASCENDING.getValue()) {
				searchResultModelList = searchResultModelList.stream()
						.sorted(Comparator.comparing(SearchResultModel::getTotalDuration)).collect(Collectors.toList());
			} else {
				searchResultModelList = searchResultModelList.stream()
						.sorted(Comparator.comparing(SearchResultModel::getTotalDuration).reversed())
						.collect(Collectors.toList());
			}
			break;
		default:
			// list was already sorted in natural order based on fare.
			break;
		}
		SearchResultListModel searchResultListModelList = new SearchResultListModel();
		searchResultListModelList.setSearchResultModelList(searchResultModelList);
		searchResultListModelList.setTotalResultCount(searchResultModelList.size());
		return searchResultListModelList;
	}

	@Override
	public SearchResultListModel findAll() {
		List<BusDetailsEntity> busDetailsEntityList = busDetailsRepository.findAll();
		if(CollectionUtils.isEmpty(busDetailsEntityList)) {
			throw new ResourceNotFoundException("No Bus available.");
		} else {
		List<SearchResultModel> searchResultModelList = SearchResultModel.formSearchResultModel(busDetailsEntityList);
		SearchResultListModel searchResultListModelList = new SearchResultListModel();
		searchResultListModelList.setSearchResultModelList(searchResultModelList);
		searchResultListModelList.setTotalResultCount(searchResultModelList.size());
		return searchResultListModelList;
		}
	}

	@Override
	public SearchResultListModel getSearchResult(SearchModel searchModel) {
		List<BusDetailsEntity> busDetailsEntityList = new ArrayList<>();
		if (Objects.nonNull(searchModel.getReturnDate())) {
			busDetailsEntityList = busDetailsRepository.findBySourceCityAndDestinationCityAndTravelDateAndReturnDate(
					searchModel.getSourceCity(), searchModel.getDestinationCity(),
					searchModel.getTravelDate(), searchModel.getReturnDate());
		} else {
			busDetailsEntityList = busDetailsRepository.findBySourceCityAndDestinationCityAndTravelDate(
					searchModel.getSourceCity(), searchModel.getDestinationCity(),
					searchModel.getTravelDate());
		}
		List<SearchResultModel> searchResultModelList = new ArrayList<>();
		if(!CollectionUtils.isEmpty(busDetailsEntityList)) {
			searchResultModelList = SearchResultModel.formSearchResultModel(busDetailsEntityList);
		}
		if(CollectionUtils.isEmpty(searchResultModelList)) {
			throw new ResourceNotFoundException("Search Results not found.");
		} else {
		SearchResultListModel searchResultListModel = new SearchResultListModel();
		searchResultListModel.setSearchResultModelList(searchResultModelList);
		searchResultListModel.setTotalResultCount(searchResultModelList.size());
		return searchResultListModel;
		}
	}

	@Override
	public SeatAvailabilityModel checkAvailability(String busNumber) {
		List<SeatReservationDetailsEntity> seatReservationDetailsEntityList = seatReservationDetailsRepository.findByBusNumber(busNumber);
		if(CollectionUtils.isEmpty(seatReservationDetailsEntityList)) {
			throw new ResourceNotFoundException("No Seats Available.");
		} else {
			SeatAvailabilityModel seatAvailabilityModel = new SeatAvailabilityModel();
			seatAvailabilityModel.setTotalSeats(seatReservationDetailsEntityList.size());
			seatAvailabilityModel.setAvailableSeatNumberList(seatReservationDetailsEntityList.stream().filter(filter -> !filter.isBooked())
					.map(SeatReservationDetailsEntity::getSeatNumber).collect(Collectors.toList()));
			seatAvailabilityModel.setAvailableSeats(seatAvailabilityModel.getAvailableSeatNumberList().size());
			seatAvailabilityModel.setUnAvailableSeatNumberList(seatReservationDetailsEntityList.stream().filter(SeatReservationDetailsEntity::isBooked)
					.map(SeatReservationDetailsEntity::getSeatNumber).collect(Collectors.toList()));
			seatAvailabilityModel.setUnAvailableSeats(seatAvailabilityModel.getUnAvailableSeatNumberList().size());
			return seatAvailabilityModel;
		}
	}

	@Override
	public BookingStatusModel bookTicket(TicketBookingModel ticketBookingModel) {
		BookingStatusModel bookingStatusModel = new BookingStatusModel();
		bookingStatusModel.setBusNumber(ticketBookingModel.getBusNumber());
		bookingStatusModel.setUserId(ticketBookingModel.getUserId());
		if (Objects.nonNull(ticketBookingModel.getSeatNumber())) {
			bookingStatusModel.setSeatNumber(ticketBookingModel.getSeatNumber());
			bookingStatusModel.setFare(busDetailsRepository.findByBusNumber(ticketBookingModel.getBusNumber()).getFare() * 1.1);
		} else {
			List<SeatReservationDetailsEntity> seatEntityList = seatReservationDetailsRepository
					.findByBusNumber(ticketBookingModel.getBusNumber());
			Optional<String> firstModel = seatEntityList.stream().filter(filter -> !filter.isBooked())
					.map(SeatReservationDetailsEntity::getSeatNumber).findFirst();
			bookingStatusModel.setSeatNumber(firstModel.get());
			bookingStatusModel.setFare(busDetailsRepository.findByBusNumber(ticketBookingModel.getBusNumber()).getFare());
		}
		SeatReservationDetailsEntity updateSeatReservationDetailsEntity = seatReservationDetailsRepository
				.findBySeatNumberAndBusNumber(bookingStatusModel.getSeatNumber(),ticketBookingModel.getBusNumber());
		if(Objects.nonNull(updateSeatReservationDetailsEntity)) {
			updateSeatReservationDetailsEntity.setBooked(true);
			updateSeatReservationDetailsEntity.setBusNumber(bookingStatusModel.getBusNumber());
			updateSeatReservationDetailsEntity.setFare(bookingStatusModel.getFare());
			updateSeatReservationDetailsEntity.setSeatNumber(bookingStatusModel.getSeatNumber());
			updateSeatReservationDetailsEntity.setUserId(ticketBookingModel.getUserId());
			seatReservationDetailsRepository.save(updateSeatReservationDetailsEntity);
			return bookingStatusModel;
		} else {
			throw new ResourceNotFoundException("Booking Failed");
		}
	}
}
