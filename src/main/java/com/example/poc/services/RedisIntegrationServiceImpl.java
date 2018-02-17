package com.example.poc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.poc.document.Book;
import com.example.poc.repository.BookRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Service
@Slf4j
public class RedisIntegrationServiceImpl implements RedisIntegrationService {

	private static final Logger log= LoggerFactory.getLogger(RedisIntegrationServiceImpl.class);
	@Autowired
	private BookRepository repository;
	@Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Long count() {
        return this.repository.count();
    }

    @Override
    public Book save(Book book) {
        log.info("Saving book :{}", book);
        return this.repository.save(book);
    }

    @Override
    public Book findBookByTitle(String title) {
        log.info("Finding Book by Title :{}", title);
        return this.repository.findByTitle(title);
    }

    @Override
    public Book updateByTitle(String title, String author) {
        log.info("Updating Book Author by Title :{} with {}", title, author);
        final Query query = new Query(Criteria.where("title").is(title));
        final Update update = new Update().set("author", author);
        return this.mongoTemplate.findAndModify(query, update,
                new FindAndModifyOptions().returnNew(true).upsert(false), Book.class);
    }

    @Override
    public void deleteBook(String id) {
        log.info("deleting Books by id :{}", id);
        this.repository.delete(id);
    }

    @Override
    public void deleteAllCache() {
        log.info("Deleting Cache");
    }

    @Override
    public void deleteAllCollections() {
        this.repository.deleteAll();
    }

}