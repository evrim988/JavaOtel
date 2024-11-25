package org.example.javaotel.dto.request;

import org.example.javaotel.entity.ERoomStatus;
import org.example.javaotel.entity.ERoomType;

public record AddRoomRequestDto(
		ERoomType roomType,
		ERoomStatus roomStatus
) {
}