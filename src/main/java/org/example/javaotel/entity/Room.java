package org.example.javaotel.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tbl_room")
public class Room extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Enumerated(EnumType.STRING)
	ERoomType roomType;

	@Enumerated(EnumType.STRING)
	ERoomStatus roomStatus;
}