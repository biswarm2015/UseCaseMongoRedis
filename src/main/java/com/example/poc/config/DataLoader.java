package com.example.poc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.poc.controller.IntegrationController;
import com.example.poc.document.Book;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

	@Autowired
    private IntegrationController controller;

    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        final Long cnt = controller.count();
        if (cnt == 0) {
            //controller.deleteCache();
            final Book book = new Book();
            book.setTitle("MongoDbCookBook");
            book.setText("MongoDB Data Book");
            book.setAuthor("Raja");
            controller.saveBook(book);
        }
    }
}