package com.example.libraryservice.repository;

import com.example.libraryservice.model.Library_books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Library_booksRepository extends JpaRepository<Library_books, Integer> {
    List<Library_books> findAllByLibrary_id(Integer library_id);
}
