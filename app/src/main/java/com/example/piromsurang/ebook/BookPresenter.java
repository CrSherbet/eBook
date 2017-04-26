package com.example.piromsurang.ebook;

import android.widget.ArrayAdapter;

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
        view.showList(repository.getBookList());
    }

}
