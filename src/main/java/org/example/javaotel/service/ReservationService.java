package org.example.javaotel.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.javaotel.dto.request.AddReservationRequestDto;
import org.example.javaotel.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {
	private final ReservationRepository reservationRepository;
	
	public void addReservation(AddReservationRequestDto dto) {
	
	}
}