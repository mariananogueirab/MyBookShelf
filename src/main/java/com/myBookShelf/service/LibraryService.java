package com.myBookShelf.service;

import com.myBookShelf.controller.Book;
import com.myBookShelf.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    LibraryRepository repository;

    public String buildId (String isbn, int year) {
        return isbn + "-" + year;
    }

    public boolean checkIfBookAlreadyExists(String id) {
        Optional<Book> book = repository.findById(id);
        if(book.isPresent()) {
            return true;
        }
        else {
            return false;
        }
    }
}
