package org.example.javaotel.dto.request;

import java.time.LocalDate;

public record AddReservationRequestDto(
		Long roomId,
		String customerName,
		String customerEmail,
		LocalDate checkInDate,
		LocalDate checkOutDate,
		Long adultCount,
		Long childCount
) {
}