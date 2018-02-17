package com.example.poc.services;

import com.example.poc.document.Book;

public interface RedisIntegrationService {

    Long count();

    Book save(Book book);

    Book findBookByTitle(String title);

    Book updateByTitle(String title, String author);

    void deleteBook(String id);

    void deleteAllCache();

    void deleteAllCollections();

}