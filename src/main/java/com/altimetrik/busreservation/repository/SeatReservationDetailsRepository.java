package com.altimetrik.busreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.busreservation.entity.SeatReservationDetailsEntity;

@Repository
public interface SeatReservationDetailsRepository extends JpaRepository<SeatReservationDetailsEntity, Long> {

	List<SeatReservationDetailsEntity> findByBusNumber(String busNumber);

	SeatReservationDetailsEntity findBySeatNumberAndBusNumber(String seatNumber, String busNumber);

}
