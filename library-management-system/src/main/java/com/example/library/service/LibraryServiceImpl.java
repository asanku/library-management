package com.example.library.service;

import com.example.library.domain.Author;
import com.example.library.domain.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService{
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id){
        return authorRepository.findById(id);
    }

    public Author saveAuthor(Author author){
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
