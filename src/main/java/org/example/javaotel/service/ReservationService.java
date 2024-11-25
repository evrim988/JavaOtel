package org.example.javaotel.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.javaotel.dto.request.AddReservationRequestDto;
import org.example.javaotel.entity.ERoomStatus;
import org.example.javaotel.entity.Reservation;
import org.example.javaotel.entity.Room;
import org.example.javaotel.exception.ErrorType;
import org.example.javaotel.exception.JavaOtelException;
import org.example.javaotel.mapper.ReservationMapper;
import org.example.javaotel.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {
	private final ReservationRepository reservationRepository;
	private final RoomService roomService;
	
	public void addReservation(AddReservationRequestDto dto) {
		Optional<Room> optionalRoom =  roomService.findByRoomId(dto.roomId());
		if(optionalRoom.isEmpty())
			throw new JavaOtelException(ErrorType.ROOM_NOTFOUND);

		Room room = optionalRoom.get();


		if(existRoomAvailable(dto.roomId(), dto.checkInDate(), dto.checkOutDate())){
			throw new JavaOtelException(ErrorType.ROOM_UNAVAILABLE);
		}


		if (!(existRoomAvailable(dto.roomId(), dto.checkInDate(), dto.checkOutDate()))) {
			Reservation reservation = ReservationMapper.INSTANCE.fromAddReservationRequestDto(dto);
			room.setRoomStatus(ERoomStatus.UNAVAILABLE);
			reservationRepository.save(reservation);
		}


	}


	public boolean existRoomAvailable(Long roomId, LocalDate checkInDate, LocalDate checkOutDate) {
		Boolean exists = reservationRepository.existsByRoomIdAndCheckInDateGreaterThanEqualAndCheckOutDateLessThanEqual(roomId, checkInDate, checkOutDate);
		System.out.println(exists);
		return exists;
	}


}