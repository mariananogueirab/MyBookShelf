package com.myBookShelf.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Response {
    private String id;
    private String message;
}
