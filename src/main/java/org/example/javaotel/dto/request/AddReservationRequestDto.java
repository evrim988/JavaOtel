package org.example.javaotel.dto.request;

import org.example.javaotel.entity.ECustomerType;
import org.example.javaotel.entity.ERoomType;

import java.time.LocalDate;

public record AddReservationRequestDto(
		Long roomId,
		String customerName,
		String customerEmail,
		LocalDate checkInDate,
		LocalDate checkOutDate,
		ECustomerType customerType
) {
}