package com.myBookShelf.service;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    public String buildId (String isbn, String year) {
        return isbn + "-" + year;
    }
}
