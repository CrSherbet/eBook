package com.example.piromsurang.ebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.piromsurang.ebook.model.Book;
import com.example.piromsurang.ebook.model.BookRepository;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BookView {

    private BookRepository repository;
    private BookPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repository = BookRepository.getInstance();
        presenter = new BookPresenter(repository, this);
        presenter.printList();
    }

    @Override
    public void showList(String result) {
        TextView textView = (TextView)findViewById(R.id.list_books);
        textView.setText(result);
    }
}
