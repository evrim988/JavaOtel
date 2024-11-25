package org.example.javaotel.utility;

import jakarta.annotation.PostConstruct;
import org.example.javaotel.entity.ERoomStatus;
import org.example.javaotel.entity.ERoomType;
import org.example.javaotel.entity.Room;
import org.example.javaotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenerateData {
    @Autowired
    private RoomRepository repository;

    @PostConstruct
    public void generate() {
        List<Room> roomList = repository.findAll();
        if (roomList.isEmpty()) {
            createRooms();
        }
    }

    private void createRooms() {
        Room room = Room.builder()
                .roomStatus(ERoomStatus.AVAILABLE)
                .roomType(ERoomType.JUNIOR_SUITE)
                .build();
        Room room2 = Room.builder()
                .roomStatus(ERoomStatus.AVAILABLE)
                .roomType(ERoomType.JUNIOR_SUITE)
                .build();
        Room room3 = Room.builder()
                .roomStatus(ERoomStatus.AVAILABLE)
                .roomType(ERoomType.JUNIOR_SUITE)
                .build();
        Room room4 = Room.builder()
                .roomStatus(ERoomStatus.AVAILABLE)
                .roomType(ERoomType.JUNIOR_SUITE)
                .build();
        Room room5 = Room.builder()
                .roomStatus(ERoomStatus.AVAILABLE)
                .roomType(ERoomType.JUNIOR_SUITE)
                .build();

        Room room6 = Room.builder()
                .roomStatus(ERoomStatus.AVAILABLE)
                .roomType(ERoomType.EXECUTIVE_SUITE)
                .build();
        Room room7 = Room.builder()
                .roomStatus(ERoomStatus.AVAILABLE)
                .roomType(ERoomType.EXECUTIVE_SUITE)
                .build();
        Room room8 = Room.builder()
                .roomStatus(ERoomStatus.AVAILABLE)
                .roomType(ERoomType.EXECUTIVE_SUITE)
                .build();
        Room room9 = Room.builder()
                .roomStatus(ERoomStatus.AVAILABLE)
                .roomType(ERoomType.EXECUTIVE_SUITE)
                .build();
        Room room10 = Room.builder()
                .roomStatus(ERoomStatus.AVAILABLE)
                .roomType(ERoomType.EXECUTIVE_SUITE)
                .build();

        Room room11 = Room.builder()
                .roomStatus(ERoomStatus.AVAILABLE)
                .roomType(ERoomType.SUPER_DELUXE)
                .build();

        Room room12 = Room.builder()
                .roomStatus(ERoomStatus.AVAILABLE)
                .roomType(ERoomType.SUPER_DELUXE)
                .build();

        Room room13 = Room.builder()
                .roomStatus(ERoomStatus.AVAILABLE)
                .roomType(ERoomType.SUPER_DELUXE)
                .build();

        Room room14 = Room.builder()
                .roomStatus(ERoomStatus.AVAILABLE)
                .roomType(ERoomType.SUPER_DELUXE)
                .build();

        Room room15 = Room.builder()
                .roomStatus(ERoomStatus.AVAILABLE)
                .roomType(ERoomType.SUPER_DELUXE)
                .build();
        repository.saveAll(List.of(room, room2, room3, room4, room5, room6,
                room7, room8, room9, room10, room11, room12,
                room13, room14, room15));
    }
}
