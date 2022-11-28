package com.example.reservationservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "reservation")
@Getter
@Setter
public class Reservation {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private UUID reservation_uid;

    @Column(length = 80)
    @NotNull
    private String username;

    @NotNull
    private UUID book_uid;

    @NotNull
    private UUID library_uid;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) NOT NULL CHECK (status IN ('RENTED', 'RETURNED', 'EXPIRED'))")
    @NotNull
    private Status status;

    @NotNull
    private Date start_date;

    @NotNull
    private Date till_date;

}