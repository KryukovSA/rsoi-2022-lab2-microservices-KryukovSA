package com.example.reservationservice.service;

import com.example.reservationservice.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
}
