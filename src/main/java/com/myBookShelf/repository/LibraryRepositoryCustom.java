package com.myBookShelf.repository;

import com.myBookShelf.controller.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepositoryCustom {

    List<Book> findAllByAuthor(String author);
}
