package com.myBookShelf.repository;

import com.myBookShelf.controller.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Book, String>, LibraryRepositoryCustom {
}
