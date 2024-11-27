package org.example.javaotel.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.javaotel.dto.request.AddReservationRequestDto;
import org.example.javaotel.dto.request.AddRoomRequestDto;
import org.example.javaotel.dto.request.DeleteRoomRequestDto;
import org.example.javaotel.dto.request.UpdateRoomRequestDto;
import org.example.javaotel.dto.response.BaseResponse;
import org.example.javaotel.entity.Room;
import org.example.javaotel.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.example.javaotel.constant.RestApis.*;

@RestController
@RequestMapping(ROOM)
@RequiredArgsConstructor
@CrossOrigin("*")
public class RoomController {
	private final RoomService roomService;

	@PostMapping(ADD_ROOM)
	public ResponseEntity<BaseResponse<Boolean>> addReservation(@RequestBody @Valid AddRoomRequestDto dto){
		roomService.addRoom(dto);
		return ResponseEntity.ok(BaseResponse.<Boolean>builder()
		                                     .code(200)
		                                     .success(true)
		                                     .message("Oda Ekleme İşlemi Başarılı...")
		                                     .data(true)
		                                     .build());
	}

	@GetMapping(ROOM_LIST)
	public ResponseEntity<BaseResponse<List<Room>>> findAllRooms() {
		return ResponseEntity.ok(BaseResponse.<List<Room>>builder()
						.code(200)
						.success(true)
						.message("Oda listeleme işlemi başarılı...")
						.data(roomService.findAll())
				.build());
	}

	@PutMapping(ROOM_UPDATE)
	public ResponseEntity<BaseResponse<Boolean>> updateRoom(@RequestBody @Valid UpdateRoomRequestDto dto){
		roomService.updateRoom(dto);
		return ResponseEntity.ok(BaseResponse.<Boolean>builder()
						.code(200)
						.success(true)
						.message("Oda başarı ile güncellendi.")
						.data(true)
				.build());
	}

	@PostMapping(ROOM_DELETE)
	public ResponseEntity<BaseResponse<Boolean>> deleteRoom(@RequestBody @Valid DeleteRoomRequestDto dto){
		roomService.deleteRoom(dto.id());
		return ResponseEntity.ok(BaseResponse.<Boolean>builder()
				.code(200)
				.success(true)
				.message("Oda silme işlemi başarılı.")
				.data(true)
				.build());
	}

}