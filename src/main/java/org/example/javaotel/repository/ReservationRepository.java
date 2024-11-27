package org.example.javaotel.repository;

import org.example.javaotel.entity.Reservation;
import org.example.javaotel.views.VwReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Boolean existsByRoomIdAndCheckInDateGreaterThanEqualAndCheckOutDateLessThanEqual(Long roomId, LocalDate checkInDate, LocalDate checkOutDate);


}