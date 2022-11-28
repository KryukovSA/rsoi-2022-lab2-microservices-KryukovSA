package com.example.libraryservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "library_books")
@Getter
@Setter
public class Library_books {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "INT REFERENCES books (id)")
    private Integer  book_id;

    @Column(columnDefinition = "INT REFERENCES library (id)")
    private Integer  library_id;

    @NotNull
    private  Integer available_count;

}