package com.myBookShelf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.myBookShelf.controller", "com.myBookShelf.repository", "com.myBookShelf.service"})
public class MyBookShelfApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBookShelfApplication.class, args);
	}

}
