package com.example.piromsurang.ebook;

import com.example.piromsurang.ebook.model.Book;
import com.example.piromsurang.ebook.model.BookRepository;

import java.util.ArrayList;

/**
 * Created by Piromsurang on 4/20/2017 AD.
 */

public class BookPresenter {

    private BookRepository repository;
    private BookView view;

    public BookPresenter( BookRepository repository, BookView view ) {
        this.repository = repository;
        this.view = view;
    }

    public void printList() {
        ArrayList<Book> list = repository.getBookList();
        String result = "";
        for( int i = 0 ; i < list.size() ; i++ ) {
            result += "Title: " + list.get(i).getTitle() + " Price: " + list.get(i).getPrice() + "\n";
        }

        view.showList(result);
    }

}
