package org.example.javaotel.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.javaotel.dto.request.AddReservationRequestDto;
import org.example.javaotel.dto.request.UpdateReservationRequestDto;
import org.example.javaotel.dto.response.BaseResponse;
import org.example.javaotel.entity.Reservation;
import org.example.javaotel.service.ReservationService;
import org.example.javaotel.views.VwReservation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.example.javaotel.constant.RestApis.*;

@RestController
@RequestMapping(RESERVATION)
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReservationController {
	private final ReservationService reservationService;
	
	@PostMapping(ADD_RESERVATION)
	public ResponseEntity<BaseResponse<Boolean>> addReservation(@RequestBody @Valid AddReservationRequestDto dto){
		reservationService.addReservation(dto);
		return ResponseEntity.ok(BaseResponse.<Boolean>builder()
				                         .code(200)
				                         .success(true)
				                         .message("Reservation successfully added")
				                         .data(true)
		                                     .build());
	}


	@GetMapping(RESERVATION_LIST)
	public ResponseEntity<BaseResponse<List<Reservation>>> getResevationList(){
		return ResponseEntity.ok(BaseResponse.<List<Reservation>>builder()
						.code(200)
						.success(true)
						.message("Ok.")
						.data(reservationService.findAll())
				.build());
	}

	@PutMapping(RESERVATION_UPDATE)
	public ResponseEntity<BaseResponse<Boolean>> updateReservation(@RequestBody @Valid UpdateReservationRequestDto dto){
		reservationService.updateReservation(dto);
		return ResponseEntity.ok(BaseResponse.<Boolean>builder()
						.code(200)
						.success(true)
						.message("Reservation successfully updated")
						.data(true)
				.build());
	}
}