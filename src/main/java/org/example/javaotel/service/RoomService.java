package org.example.javaotel.service;


import lombok.RequiredArgsConstructor;
import org.example.javaotel.dto.request.AddRoomRequestDto;
import org.example.javaotel.entity.Room;
import org.example.javaotel.mapper.RoomMapper;
import org.example.javaotel.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {
	private final RoomRepository roomRepository;
	
	public void addRoom(AddRoomRequestDto dto) {
		Room addRoom = RoomMapper.INSTANCE.fromAddRoomRequestDto(dto);
		roomRepository.save(addRoom);
	}
}