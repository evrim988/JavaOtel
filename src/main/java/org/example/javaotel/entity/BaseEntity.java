package org.example.javaotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Enumerated(EnumType.STRING)
    @Builder.Default
    EState state = EState.ACTIVE;

    @CreationTimestamp
    @Column(updatable = false)
    LocalDate createAt;

    @CreationTimestamp

    LocalDate updateAt;



}
