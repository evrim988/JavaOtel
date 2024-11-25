package org.example.javaotel.mapper;

import org.example.javaotel.dto.request.AddRoomRequestDto;
import org.example.javaotel.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoomMapper {
	
	RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);
	
	Room fromAddRoomRequestDto(final AddRoomRequestDto dto);
}