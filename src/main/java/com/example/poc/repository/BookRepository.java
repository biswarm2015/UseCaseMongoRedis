package com.example.poc.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.poc.document.Book;


public interface BookRepository extends MongoRepository<Book, String> {
    
   
    Book findByTitle(String title);

    Optional<Book> findById(String id);
}