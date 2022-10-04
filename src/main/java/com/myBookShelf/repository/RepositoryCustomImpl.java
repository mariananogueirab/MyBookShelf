package com.myBookShelf.repository;

import com.myBookShelf.controller.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RepositoryCustomImpl implements LibraryRepositoryCustom{

    @Autowired
    LibraryRepository repository;

    @Override
    public List<Book> findAllByAuthor(String author) {
        List<Book> allBooks = repository.findAll();
        List<Book> booksByAuthorName = new ArrayList<>();
        for (Book book : allBooks) {
            if(book.getAuthor().equalsIgnoreCase(author)) {
                booksByAuthorName.add(book);
            }
        }

        return booksByAuthorName;
    }
}
