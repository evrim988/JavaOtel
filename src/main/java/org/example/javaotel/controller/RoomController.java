package org.example.javaotel.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.javaotel.dto.request.AddReservationRequestDto;
import org.example.javaotel.dto.request.AddRoomRequestDto;
import org.example.javaotel.dto.response.BaseResponse;
import org.example.javaotel.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.example.javaotel.constant.RestApis.*;

@RestController
@RequestMapping(ROOM)
@RequiredArgsConstructor
public class RoomController {
	private final RoomService roomService;
	@PostMapping(ADD_ROOM)
	public ResponseEntity<BaseResponse<Boolean>> addReservation(@RequestBody @Valid AddRoomRequestDto dto){
		roomService.addRoom(dto);
		return ResponseEntity.ok(BaseResponse.<Boolean>builder()
		                                     .code(200)
		                                     .success(true)
		                                     .message("Reservation successfully added")
		                                     .data(true)
		                                     .build());
	}
}