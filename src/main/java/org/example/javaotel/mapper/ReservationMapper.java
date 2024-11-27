package org.example.javaotel.mapper;

import org.example.javaotel.dto.request.AddReservationRequestDto;
import org.example.javaotel.dto.request.UpdateReservationRequestDto;
import org.example.javaotel.entity.Reservation;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    Reservation fromAddReservationRequestDto(AddReservationRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Reservation fromUpdateReservationRequestDto(UpdateReservationRequestDto dto, @MappingTarget Reservation reservation);

}
