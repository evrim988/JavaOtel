package org.example.javaotel.mapper;

import org.example.javaotel.dto.request.AddReservationRequestDto;
import org.example.javaotel.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    Reservation fromAddReservationRequestDto(AddReservationRequestDto dto);
}
