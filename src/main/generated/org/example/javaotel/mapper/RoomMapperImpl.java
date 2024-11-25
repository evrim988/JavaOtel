package org.example.javaotel.mapper;

import javax.annotation.processing.Generated;
import org.example.javaotel.dto.request.AddRoomRequestDto;
import org.example.javaotel.entity.Room;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-25T15:19:58+0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class RoomMapperImpl implements RoomMapper {

    @Override
    public Room fromAddRoomRequestDto(AddRoomRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Room.RoomBuilder<?, ?> room = Room.builder();

        room.roomType( dto.roomType() );
        room.roomStatus( dto.roomStatus() );

        return room.build();
    }
}
