package com.example.piromsurang.ebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.piromsurang.ebook.model.Book;
import com.example.piromsurang.ebook.model.BookRepository;

import java.util.ArrayList;
import java.util.List;

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
    public void showList(ArrayList<Book> books) {
        ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this, android.R.layout.simple_expandable_list_item_1, books);
        ListView listView = (ListView)findViewById(R.id.list_books);
        listView.setAdapter(adapter);
    }
}
