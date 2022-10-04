package com.myBookShelf.controller;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="library")
public class Book {
    @Column(name="id")
    @Id
    private String id;

    @Column(name = "bookName")
    private String bookName;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "author")
    private String author;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "year")
    private int year;

    @Column(name = "isRead")
    private int isRead;

}
