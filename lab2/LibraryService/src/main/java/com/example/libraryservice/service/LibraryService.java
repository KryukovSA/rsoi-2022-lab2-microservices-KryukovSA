package com.example.libraryservice.service;

import com.example.libraryservice.model.Books;
import com.example.libraryservice.model.Library;
import com.example.libraryservice.model.Library_books;
import com.example.libraryservice.repository.BooksRepository;
import com.example.libraryservice.repository.LibraryRepository;
import com.example.libraryservice.repository.Library_booksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final BooksRepository booksRepository;
    private final Library_booksRepository library_booksRepository;



    public List<Library> getCityLibraries(String city) {
        List<Library> libraries = libraryRepository.findAllByCity(city);
        return libraries;
    }

    public List<Books> getLibraryBooks(UUID libraryUUID, Boolean showAll) {
        Library library = libraryRepository.findByLibrary_uid(libraryUUID);
        List<Library_books> library_books = library_booksRepository.findAllByLibrary_id(library.getId());
        List<Books> books = new ArrayList<Books>();
        for (Library_books i: library_books) {
            int id = i.getBook_id();
            books.add(booksRepository.findById(id));
        }
        return books;
    }


    public  Library getLibraryInfo(UUID uuid) {
        return libraryRepository.findByLibrary_uid(uuid);
    }


    public Books getBookInfo(UUID libraryUuid, UUID bookUuid) {
        Library library = libraryRepository.findByLibrary_uid(libraryUuid);
        Books books = booksRepository.findByBook_uid(bookUuid);

        List<Books> listBooks = new ArrayList<Books>();
        List<Library_books> library_books = library_booksRepository.findAllByLibrary_id(library.getId());
        for (Library_books i: library_books) {
            int id = i.getBook_id();
            listBooks.add(booksRepository.findById(id));
        }

        if(listBooks.contains(books)) {
            return books;
        }
        return null;
    }


}
