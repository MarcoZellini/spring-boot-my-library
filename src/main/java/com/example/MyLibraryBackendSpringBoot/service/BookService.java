package com.example.MyLibraryBackendSpringBoot.service;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.MyLibraryBackendSpringBoot.model.Book;
import com.example.MyLibraryBackendSpringBoot.repository.IBookRepository;

@Service
public class BookService {

    @Autowired
    private IBookRepository bookRepository;

    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> getById(long id) {
        return bookRepository.findById(id);
    }

    /*
     * Ho utilizzato questa annotation perche' non riuscivo a capire il motivo del
     * warning che mi dava
     */
    @SuppressWarnings("null")
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    /*
     * Ho utilizzato questa annotation perche' non riuscivo a capire il motivo del
     * warning che mi dava
     */
    @SuppressWarnings("null")
    public Optional<Book> update(long id, Book book) {
        Optional<Book> bookFound = bookRepository.findById(id);

        if (bookFound.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }

        bookFound.get().setTitle(book.getTitle());
        bookFound.get().setAuthor(book.getAuthor());
        bookFound.get().setIsbn(book.getIsbn());
        bookFound.get().setPlot(book.getPlot());
        bookFound.get().setTotalReadings(book.getTotalReadings());
        bookFound.get().setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        bookRepository.save(bookFound.get());

        return bookFound;
    }

    /*
     * Ho utilizzato questa annotation perche' non riuscivo a capire il motivo del
     * warning che mi dava
     */
    @SuppressWarnings("null")
    public Optional<Book> update_total_readings(long id, Book total_readings) {
        Optional<Book> bookFound = bookRepository.findById(id);

        if (bookFound.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }

        bookFound.get().setTotalReadings(total_readings);

        bookRepository.save(bookFound.get());

        return bookFound;
    }

    /*
     * Ho utilizzato questa annotation perche' non riuscivo a capire il motivo del
     * warning che mi dava
     */
    @SuppressWarnings("null")
    public Boolean delete(long id) {
        Optional<Book> bookFound = bookRepository.findById(id);

        if (bookFound.isEmpty()) {
            return false;
        }

        bookRepository.delete(bookFound.get());

        return true;
    }

}
