package com.example.piromsurang.ebook.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Piromsurang on 4/20/2017 AD.
 */

public class BookRepository implements Repository {

    private ArrayList<Book> books;
    private static BookRepository instance = null;

    private BookRepository() {
        books = new ArrayList<Book>();

        //testing
        books.add(new Book( 20, "a", "a", "a"));
        books.add(new Book( 10, "b", "b", "b"));
        books.add(new Book( 30, "c", "c", "c"));
    }

    public static BookRepository getInstance() {
        if( instance == null ) {
            instance = new BookRepository();
        }

        return instance;
    }

    public ArrayList<Book> getBookList() {
        return books;
    }

}
