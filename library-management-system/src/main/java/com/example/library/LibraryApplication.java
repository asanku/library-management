package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }
}

/*
//authors
{
  "name": "John Doe",
  "books": [
    {
      "title": "Effective Java",
      "isbn": "978-0134685991",
      "author": "Joshua Bloch"
    },
    {
      "title": "Clean Code",
      "isbn": "978-0132350884",
      "author": "Robert C. Martin"
    }
  ]
}

// books
{
  "title": "Effective Java",
  "isbn": "978-0134685991",
  "author": "Joshua Bloch"
}
 */
