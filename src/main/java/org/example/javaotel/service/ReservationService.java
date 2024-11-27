package org.example.javaotel.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.javaotel.dto.request.AddReservationRequestDto;
import org.example.javaotel.dto.request.UpdateReservationRequestDto;
import org.example.javaotel.entity.ERoomStatus;
import org.example.javaotel.entity.EState;
import org.example.javaotel.entity.Reservation;
import org.example.javaotel.entity.Room;
import org.example.javaotel.exception.ErrorType;
import org.example.javaotel.exception.JavaOtelException;
import org.example.javaotel.mapper.ReservationMapper;
import org.example.javaotel.repository.ReservationRepository;
import org.example.javaotel.views.VwReservation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReservationService {
	private final ReservationRepository reservationRepository;
	private final RoomService roomService;
	
	public void addReservation(@Valid AddReservationRequestDto dto) {
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


	public List<Reservation> findAll() {
		return reservationRepository.findAll().stream()
				.filter(reservation -> reservation.getState() == EState.ACTIVE).sorted(Comparator.comparing(Reservation::getId)).toList();
	}

	public void updateReservation(UpdateReservationRequestDto dto) {
		Optional<Reservation> reservationOptional = reservationRepository.findById(dto.id());
		if (reservationOptional.isEmpty())
			throw new JavaOtelException(ErrorType.RESERVATION_NOTFOUND);

		Optional<Room> optionalRoom = roomService.findByRoomId(dto.roomId());
		if(optionalRoom.isEmpty() || optionalRoom.get().getState().equals(EState.PASSIVE) )
			throw new JavaOtelException(ErrorType.ROOM_NOTFOUND);

		if(optionalRoom.get().getRoomStatus().equals(ERoomStatus.UNAVAILABLE)){
			throw new JavaOtelException(ErrorType.ROOM_UNAVAILABLE);
		}


		Reservation reservation = reservationOptional.get();

		if(optionalRoom.get().getRoomStatus().equals(ERoomStatus.AVAILABLE)){
			reservationRepository.save(ReservationMapper.INSTANCE.fromUpdateReservationRequestDto(dto, reservation));
		}

	}

	public void deleteByReservationId(Long id) {
		Optional<Reservation> reservationOptional = reservationRepository.findById(id);
		if (reservationOptional.isEmpty())
			throw new JavaOtelException(ErrorType.RESERVATION_NOTFOUND);
		Reservation reservation = reservationOptional.get();
		reservation.setState(EState.PASSIVE);
		reservationRepository.save(reservation);
	}
}