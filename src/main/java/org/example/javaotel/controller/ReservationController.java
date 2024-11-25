package org.example.javaotel.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.javaotel.dto.request.AddReservationRequestDto;
import org.example.javaotel.dto.response.BaseResponse;
import org.example.javaotel.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}