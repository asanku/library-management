package com.example.library.controller;

import com.example.library.domain.Author;
import com.example.library.repository.AuthorRepository;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private LibraryService libraryService;



    @GetMapping //
    public List<Author> getAuthors() {
        return libraryService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Optional<Author> authorOptional = libraryService.getAuthorById(id);
            return authorOptional.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return libraryService.saveAuthor(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        Optional<Author> authorOptional = libraryService.getAuthorById(id);
        if (authorOptional.isPresent()) {
            Author existingAuthor = authorOptional.get();
            existingAuthor.setName(author.getName());

            return ResponseEntity.ok(libraryService.saveAuthor(existingAuthor));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        Optional<Author> authorOptional = libraryService.getAuthorById(id);
        if (authorOptional.isPresent()) {
            libraryService.deleteBook(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
