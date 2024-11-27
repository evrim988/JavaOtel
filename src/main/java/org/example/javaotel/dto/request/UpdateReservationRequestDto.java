package org.example.javaotel.dto.request;

import java.time.LocalDate;

public record UpdateReservationRequestDto(
        Long id,
        Long roomId,
        String adultCount,
        String childCount,
        LocalDate checkInDate,
        LocalDate checkOutDate
) {
}
