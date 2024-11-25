package org.example.javaotel.repository;

import org.example.javaotel.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Boolean existsByRoomIdAndCheckInDateGreaterThanEqualAndCheckOutDateLessThanEqual(Long roomId, LocalDate checkInDate, LocalDate checkOutDate);
}