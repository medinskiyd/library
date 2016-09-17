package com.library.service.impl;

import com.library.db.LibraryCatalogService;
import com.library.model.Book;
import com.library.service.LibraryService;
import com.library.utils.WebException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Library service implementation.
 *
 * Created by dmitry on 16.09.16.
 */
@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryCatalogService libraryCatalogService;

    private final static Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);

    /**
     * Save new book.
     *
     * @param book {@link Book} new book.
     */
    public void save(Book book) {

        if (book == null) {
            String msg = "Book is empty!";
            logger.info(msg);
            throw new WebException(400, msg);
        }

        libraryCatalogService.save(book);

        logger.info("Book with id = " + book.getId() + " saved.");
    }

    /**
     * Save book.
     *
     * @param book {@link Book} book.
     */
    public void update(Book book) {

        if (book == null) {
            String msg = "Book is empty!";
            logger.info(msg);
            throw new WebException(400, msg);
        }

        libraryCatalogService.update(book);

        logger.info("Book with id = " + book.getId() + " updated.");

    }

    /**
     * Get book by id.
     *
     * @param id book id (String).
     * @return {@link Book} book from catalog.
     */
    public Book getById(String id) {

        if (id == null) {
            String msg = "Book id is empty!";
            logger.info(msg);
            throw new WebException(400, msg);
        }

        Book book = libraryCatalogService.getById(id);

        logger.info("Get book with id = " + id);

        return book;
    }

    /**
     * Get all books from catalog.
     *
     * @return {@link List <Book>} books from catalog.
     */
    public List<Book> getAll() {
        return libraryCatalogService.getAll();
    }

}
