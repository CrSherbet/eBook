package com.example.piromsurang.ebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.piromsurang.ebook.model.Book;
import com.example.piromsurang.ebook.model.MockUpBookRep;
import com.example.piromsurang.ebook.model.RealBookRep;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BookView {

    private RealBookRep repository;
    private BookPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textHead);
        repository = RealBookRep.getInstance();
        presenter = new BookPresenter(repository, this);
        textView.setText("HI2");

    }

    @Override
    public void showList(ArrayList<Book> books) {
        ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this, android.R.layout.simple_expandable_list_item_1, books);
        ListView listView = (ListView)findViewById(R.id.list_books);
        listView.setAdapter(adapter);
    }
}
