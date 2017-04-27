package com.example.piromsurang.ebook.model;

import java.util.ArrayList;

/**
 * Created by Piromsurang on 4/20/2017 AD.
 */

public class MockUpBookRep implements Repository {

    private ArrayList<Book> books;
    private static MockUpBookRep instance = null;

    private MockUpBookRep() {
        books = new ArrayList<Book>();
        books.add(new Book("A", "001", 25.3, 2013, "www.web.com"));
        books.add(new Book("B", "002", 288, 2053, "www.web.com"));
        books.add(new Book("C", "003", 26.38, 2413, "www.web.com"));
    }

    public static MockUpBookRep getInstance() {
        if( instance == null )
            instance = new MockUpBookRep();
        return instance;
    }

    public ArrayList<Book> getBookList() {
        return books;
    }

}
