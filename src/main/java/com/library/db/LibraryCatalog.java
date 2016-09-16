package com.library.db;

import com.library.model.Book;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by dmitry on 17.09.16.
 */
@XmlRootElement
public class LibraryCatalog {

    private List<Book> catalog;

    public List<Book> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<Book> catalog) {
        this.catalog = catalog;
    }
}
