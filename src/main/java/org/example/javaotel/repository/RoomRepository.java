package org.example.javaotel.repository;

import org.example.javaotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {


}