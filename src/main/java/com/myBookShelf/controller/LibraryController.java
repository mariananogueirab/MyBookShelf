package com.myBookShelf.controller;

import com.myBookShelf.repository.LibraryRepository;
import com.myBookShelf.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    LibraryService libraryService;

    @Autowired
    LibraryRepository repository;

    @Autowired
    Response response;

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody Book book) {
        String id = libraryService.buildId(book.getIsbn(), book.getYear());

        if(!libraryService.checkIfBookAlreadyExists(id)) {
            book.setId(id);
            repository.save(book);

            return new ResponseEntity(book, HttpStatus.CREATED);
        } else {
            response.setId(id);
            response.setMessage("Book already exist");

            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable(value="id")String id) {
        try {
            Book book = repository.findById(id).get();
            return book;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/")
    public List<Book> getBookByAuthorName(@RequestParam(value = "author") String author) {
        return repository.findAllByAuthor(author);
    }
}
