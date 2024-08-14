package com.example.library.controller;

import com.example.library.domain.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = libraryService.getBookById(id);
        return book.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());

    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return libraryService.saveBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> bookOptional = libraryService.getBookById(id);
        if (bookOptional.isPresent()) {
            Book existingBook = bookOptional.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setIsbn(book.getIsbn());
            return ResponseEntity.ok(libraryService.saveBook(existingBook));
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<Book> bookOptional = libraryService.getBookById(id);
        if (bookOptional.isPresent()) {
            libraryService.deleteBook(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
