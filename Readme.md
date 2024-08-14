# Case Study: Library Management System

## Overview

A a detailed case study that covers building a Spring Boot application with Spring Data JPA and RESTful web services. In this project, we'll create a simple application to manage a library system with basic CRUD operations for books and authors.

We will build a Spring Boot application with the following features:

- Entities: Book and Author.
- Repository Layer: Spring Data JPA repositories for CRUD operations.
- Service Layer: Business logic for handling library operations.
- REST Controller: Expose RESTful endpoints for managing books and authors.

## Tools and Technologies

- Java 17+
- Spring Boot 3.0+
- Spring Data JPA
- Spring Web
- H2/MySQL Database
- Maven
- IDE (Eclipse, IntelliJ, or VS Code)

## Project Structure

The project will have the following structure:

```bash
library-management-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── library/
│   │   │               ├── LibraryApplication.java
│   │   │               ├── controller/
│   │   │               │   ├── AuthorController.java
│   │   │               │   └── BookController.java
│   │   │               ├── model/
│   │   │               │   ├── Author.java
│   │   │               │   └── Book.java
│   │   │               ├── repository/
│   │   │               │   ├── AuthorRepository.java
│   │   │               │   └── BookRepository.java
│   │   │               └── service/
│   │   │                   └── LibraryService.java
│   │   └── resources/
│   │       ├── application.yaml
├── pom.xml
└── README.md
```

## Dependencies

Add the following dependencies in the `pom.xml` file:

```xml
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- H2 Database -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Spring Boot Starter Test -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Database Configuration

Add the following database configuration in the `application.yaml` file:

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:library
    driver-class-name: org.h2.Driver
    username: sa
    password: password
  jpa:
    hibernate:
      ddl-auto: create
    show-sql: true
```

## Entity Classes

Create the following entity classes:

1. Author.java

```java
package com.example.library.model;

@Entity
public class Author {

    @Id
    private Long id;
    private String name;

    // One author can have multiple books
    private List<Book> books;
}

@Entity
public class Book {

    @Id
    private Long id;
    private String title;
    private String isbn;
    private Author author;
}
```

## Repository Layer

Create the following repository interfaces:

1. AuthorRepository.java

```java

package com.example.library.repository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

```

2. BookRepository.java

```java

package com.example.library.repository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
```

## Service Layer

Create the following service classes:

1. LibraryService.java

```java

package com.example.library.service;

@Service
public interface LibraryService {

    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(Long id);

    Author saveAuthor(Author author);

    void deleteAuthor(Long id);

    List<Book> getAllBooks();

    Optional<Book> getBookById(Long id);

    Book saveBook(Book book);

    void deleteBook(Long id);
}

```

## REST Controller

Create the following REST controllers:

1. AuthorController.java

```java

package com.example.library.controller;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @GetMapping //
    public List<Author> getAllAuthors() {
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
    }
}

```

2. BookController.java

```java

package com.example.library.controller;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping
    public List<Book> getAllBooks() {
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {

    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    }
}

```

## Test the Application

- Run the Spring Boot application and test the RESTful endpoints using Postman or any other REST client.
- Access the H2 database console at http://localhost:8080/h2-console to inspect the data.

## Conclusion

In this case study, we have built a simple library management system using Spring Boot with Spring Data JPA and RESTful web services. We have created entities, repositories, services, and REST controllers to manage books and authors in the library system.
