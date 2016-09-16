package com.library.service;

import com.library.model.Book;

import java.util.List;

/**
 * Library service.
 * <p>
 * Created by dmitry on 16.09.16.
 */
public interface LibraryService {

    /**
     * Save new book.
     *
     * @param book {@link Book} new book.
     */
    void save(Book book);

    /**
     * Save book.
     *
     * @param book {@link Book} book.
     */
    void update(Book book);

    /**
     * Get book by id.
     *
     * @param id book id (String).
     * @return {@link Book} book from catalog.
     */
    Book getById(String id);

    /**
     * Get all books from catalog.
     *
     * @return {@link List<Book>} books from catalog.
     */
    List<Book> getAll();
}
