package com.example.MyLibraryBackendSpringBoot.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.MyLibraryBackendSpringBoot.model.Book;
import com.example.MyLibraryBackendSpringBoot.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    public Iterable<Book> getAll() {
        return bookService.getAll();
    }

    @RequestMapping("/books/{id}")
    public Optional<Book> getById(@PathVariable long id) {
        return bookService.getById(id);
    }

    @RequestMapping(value = "/books/create", method = RequestMethod.POST)
    public Book create(@Valid @RequestBody Book book) {
        return bookService.create(book);
    }

    @RequestMapping(value = "/books/{id}/edit", method = RequestMethod.PUT)
    public Book update(@Valid @PathVariable long id, @RequestBody Book book) {

        Optional<Book> bookFound = bookService.update(id, book);

        if (bookFound.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }

        return bookFound.get();
    }

    @RequestMapping(value = "/books/{id}/update_readings", method = RequestMethod.PUT)
    public Book update_total_readings(@Valid @PathVariable long id, @RequestBody Book total_readings) {
        Optional<Book> bookFound = bookService.update_total_readings(id, total_readings);

        if (bookFound.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }

        return bookFound.get();
    }

    @RequestMapping(value = "/books/{id}/delete", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        Boolean isDeleted = bookService.delete(id);

        if (isDeleted) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
    }

}
