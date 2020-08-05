package com.altimetrik.busreservation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.busreservation.entity.BusDetailsEntity;

@Repository
public interface BusDetailsRepository extends JpaRepository<BusDetailsEntity, Long> {

	List<BusDetailsEntity> findBySourceCityAndDestinationCityAndTravelDateAndReturnDate(String sourceCity,
			String destinationCity, Date travelDate, Date returnDate);

	List<BusDetailsEntity> findBySourceCityAndDestinationCityAndTravelDate(String sourceCity, String destinationCity,
			Date travelDate);

	BusDetailsEntity findByBusNumber(String busNumber);

}
