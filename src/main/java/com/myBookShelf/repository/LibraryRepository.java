package com.myBookShelf.repository;

import com.myBookShelf.controller.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Book, String> {
}
