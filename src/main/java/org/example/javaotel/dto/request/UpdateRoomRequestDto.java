package org.example.javaotel.dto.request;

import org.example.javaotel.entity.ERoomStatus;

public record UpdateRoomRequestDto(
        Long id,
        ERoomStatus roomStatus
) {
}
