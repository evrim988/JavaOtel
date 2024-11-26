package org.example.javaotel.service;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.javaotel.dto.request.AddRoomRequestDto;
import org.example.javaotel.dto.request.UpdateRoomRequestDto;
import org.example.javaotel.entity.EState;
import org.example.javaotel.entity.Room;
import org.example.javaotel.exception.ErrorType;
import org.example.javaotel.exception.JavaOtelException;
import org.example.javaotel.mapper.RoomMapper;
import org.example.javaotel.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {
	private final RoomRepository roomRepository;
	
	public void addRoom(AddRoomRequestDto dto) {
		Room addRoom = RoomMapper.INSTANCE.fromAddRoomRequestDto(dto);
		roomRepository.save(addRoom);
	}

	public Optional<Room> findByRoomId(Long roomId) {
		return roomRepository.findById(roomId);
	}

	public List<Room> findAll() {
		return roomRepository.findAll().stream()
				.filter(room -> room.getState() == EState.ACTIVE).sorted(Comparator.comparing(Room::getId)).toList();
	}

	public void updateRoom(UpdateRoomRequestDto dto) {
		Optional<Room> optionalRoom = roomRepository.findById(dto.id());
		if(optionalRoom.isEmpty())
			throw new JavaOtelException(ErrorType.ROOM_NOTFOUND);
		Room room = optionalRoom.get();
		room.setRoomStatus(dto.roomStatus());
		roomRepository.save(room);
	}

	public void deleteRoom(@Valid Long id) {
		Optional<Room> optionalRoom = roomRepository.findById(id);
		if (optionalRoom.isEmpty())
			throw new JavaOtelException(ErrorType.ROOM_NOTFOUND);
		Room room = optionalRoom.get();
		room.setState(EState.PASSIVE);
		roomRepository.save(room);
	}
}