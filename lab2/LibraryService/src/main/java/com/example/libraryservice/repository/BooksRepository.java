package com.example.libraryservice.repository;

import com.example.libraryservice.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {
    Books findByBook_uid(UUID uuid);
    Books findById(int id);
}