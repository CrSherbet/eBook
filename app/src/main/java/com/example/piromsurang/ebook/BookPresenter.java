package com.example.piromsurang.ebook;

import android.os.AsyncTask;

import com.example.piromsurang.ebook.model.Book;
import com.example.piromsurang.ebook.model.RealBookRep;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Piromsurang on 4/20/2017 AD.
 */

public class BookPresenter implements Observer {

    private RealBookRep repository;
    private BookView view;

    public BookPresenter(RealBookRep repository, BookView view ) {
        repository.addObserver(this);
        this.repository = repository;
        this.view = view;
    }

    public void printList(){
        ArrayList<Book> book = repository.getBookList();
        view.showList(book);
    }

    @Override
    public void update(Observable o, Object arg) {
        printList();
    }
}
