package com.example.libraryservice.controller;

import com.example.libraryservice.model.Books;
import com.example.libraryservice.model.Library;
import com.example.libraryservice.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/libraries")
public class LibraryController {
    private final LibraryService libraryService;

    @GetMapping(value = "{libraryUid}/book/{bookUid}")
    public ResponseEntity<Books> getBookInfo(@PathVariable("libraryUid") UUID libraryUid,
                                             @PathVariable("bookUid") UUID bookUid) {
        return ResponseEntity.ok(libraryService.getBookInfo(libraryUid, bookUid));
    }

    @GetMapping(value = "{libraryUid}/info")
    public ResponseEntity<Library> getLibInfo(@PathVariable("libraryUid") UUID libraryUid) {
        return ResponseEntity.ok(libraryService.getLibraryInfo(libraryUid));
    }
}
