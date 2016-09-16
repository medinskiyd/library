package com.library.service.impl;

import com.library.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Library service implementation.
 * <p>
 * Created by dmitry on 16.09.16.
 */
@Service
public class LibraryServiceImpl {

    private Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);

    /**
     * Save new book.
     *
     * @param book {@link Book} new book.
     */
    void save(Book book) {

        if (book == null) {

        }

        logger.info("Book with " + book.getId() + " saved.");
    }

    /**
     * Save book.
     *
     * @param book {@link Book} book.
     */
    void update(Book book) {

    }

    /**
     * Get book by id.
     *
     * @param id book id (String).
     * @return {@link Book} book from catalog.
     */
    Book getById(String id) {
        return null;
    }

    /**
     * Get all books from catalog.
     *
     * @return {@link List <Book>} books from catalog.
     */
    List<Book> getAll() {
        return null;
    }

}
