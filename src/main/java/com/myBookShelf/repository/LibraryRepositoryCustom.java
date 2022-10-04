package com.myBookShelf.repository;

import com.myBookShelf.controller.Book;

import java.util.List;

public interface LibraryRepositoryCustom {

    List<Book> findAllBooksByAuthorName(String author);
}
