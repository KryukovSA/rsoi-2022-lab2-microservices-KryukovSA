package com.example.libraryservice.controller;

import com.example.libraryservice.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/libraries")
public class LibraryController {
    private final LibraryService libraryService;


}
