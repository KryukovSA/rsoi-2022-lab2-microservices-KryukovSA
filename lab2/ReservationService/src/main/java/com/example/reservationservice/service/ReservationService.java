package com.example.reservationservice.service;

import com.example.reservationservice.model.Reservation;
import com.example.reservationservice.model.Status;
import com.example.reservationservice.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static java.util.UUID.randomUUID;

@AllArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    //вернутть унигу
    public ResponseEntity<?> returnBook(String username, UUID reservationUid, Date date, String condition) {
        Reservation reservation = reservationRepository.findByReservation_uid(reservationUid);
        RestTemplate restTemplate = new RestTemplate();
        if(reservation == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No reservation found for " + reservationUid.toString());
        Boolean expired = false, badCondition = false;
        if (reservation.getStart_date().after(reservation.getTill_date())) {
            reservation.setStatus(Status.EXPIRED);
            expired = true;
        } else {
            reservation.setStatus(Status.RETURNED);
        }
        if(!condition.equals("EXCELLENT")) badCondition = true;
        String url;
        if(expired || badCondition) {
            url = "http://gateway:8080/api/v1/rating" + "/decrease" + "?username=" + username + "&expired=" + expired + "&badCondition=" + badCondition;
        } else {
            url = "http://gateway:8080/api/v1/rating" + "/increase" + "?username=" + username;
        }
        restTemplate.postForLocation(url, null);
        //ToDo increase available_count
        reservationRepository.save(reservation);
        return ResponseEntity.noContent().build();
    }

    // взять книгу
    public ResponseEntity<Reservation> takeBook(String username, UUID bookUid, UUID libraryUid, Date tillDate) {

        Reservation reservation = new Reservation();
        reservation.setReservation_uid(randomUUID());
        reservation.setBook_uid(bookUid);
        reservation.setLibrary_uid(libraryUid);
        reservation.setStart_date(new Date());
        reservation.setTill_date(tillDate);
        reservation.setUsername(username);
        reservation.setStatus(Status.RENTED);
        reservation = reservationRepository.save(reservation);
        return ResponseEntity.ok(reservation);
    }
    //Получить информацию по всем взятым в прокат книгам пользователя
    public ResponseEntity<List<Reservation>> getUserBooksInfo(String username) {
        List<Reservation> reservation = reservationRepository
                .findAllByUsernameAndStatusIn(username, new HashSet<>(Arrays.asList(Status.EXPIRED, Status.RENTED)));
        return ResponseEntity.ok(reservation);
    }

}
