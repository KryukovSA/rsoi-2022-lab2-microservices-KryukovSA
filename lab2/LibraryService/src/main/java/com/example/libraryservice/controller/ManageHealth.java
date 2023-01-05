package com.example.libraryservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManageHealth {
    @GetMapping("/manage/health")
    public ResponseEntity<?> getHealth() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}