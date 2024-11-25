package org.example.javaotel.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AddReservationRequestDto(
		@NotNull
		@Min(1)
		Long roomId,

		@NotNull
		String customerName,

		@Email
		String customerEmail,

		@NotNull
		String description,

		LocalDate checkInDate,
		LocalDate checkOutDate,

		@NotNull
		@Min(1)
		@Max(3)
		Long adultCount,


		@Max(2)
		Long childCount
) {
}