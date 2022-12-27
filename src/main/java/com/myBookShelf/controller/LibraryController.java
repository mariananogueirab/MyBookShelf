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

    @PostMapping("/book")
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
            return repository.findById(id).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/")
    public List<Book> getBookByAuthorName(@RequestParam(value = "author") String author) {
        return repository.findAllByAuthor(author);
    }

    @GetMapping("/all-books")
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @PutMapping("/book/{id}")
    public ResponseEntity updateBookById(@PathVariable(value = "id") String id, @RequestBody Book book) {
        try {
            Book existingBook = repository.findById(id).get();
            existingBook.setBookName(book.getBookName());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setYear(book.getYear());
            existingBook.setImgUrl(book.getImgUrl());
            existingBook.setIsRead(book.getIsRead());

            repository.save(book);

            return new ResponseEntity(book, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity deleteBook(@PathVariable(value = "id") String id){
        try {
            repository.deleteById(id);

            response.setId(id);
            response.setMessage("Book deleted");

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
