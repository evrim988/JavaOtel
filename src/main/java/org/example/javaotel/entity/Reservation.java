package org.example.javaotel.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tbl_reservation")
public class Reservation extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Long roomId;
	Long adultCount;
	Long childCount;
	String description;
	String customerName;
	String customerEmail;
	LocalDate checkInDate;
	LocalDate checkOutDate;


	
}