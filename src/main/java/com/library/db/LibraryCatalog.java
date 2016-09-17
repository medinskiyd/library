package com.library.db;

import com.library.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitry on 17.09.16.
 */
public class LibraryCatalog {

    private List<Book> catalog = new ArrayList<>();

    public List<Book> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<Book> catalog) {
        this.catalog = catalog;
    }
}
