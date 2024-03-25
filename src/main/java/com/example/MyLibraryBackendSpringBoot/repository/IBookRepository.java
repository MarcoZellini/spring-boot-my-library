package com.example.MyLibraryBackendSpringBoot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.MyLibraryBackendSpringBoot.model.Book;

@Repository
public interface IBookRepository extends CrudRepository<Book, Long> {
}
