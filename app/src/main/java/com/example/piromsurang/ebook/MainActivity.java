package com.example.piromsurang.ebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.piromsurang.ebook.model.Book;
import com.example.piromsurang.ebook.model.RealBookRep;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BookView {

    private RealBookRep repository;
    private BookPresenter presenter;
    private String type = "Title" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView) findViewById(R.id.text);
        Spinner spin = (Spinner) findViewById(R.id.selectSearchBy);
        final EditText editText= (EditText) findViewById(R.id.textForSearch);
        String [] choice = new String[]{"Title","Year"};
        spin.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,choice));
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                type = parentView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {}
        });


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start,int before, int count) {
                if(s.length() != 0) {
                    presenter.search(type, editText.getText().toString());
                }
            }
        });
        repository = RealBookRep.getInstance();
        presenter = new BookPresenter(repository, this);

    }

    @Override
    public void showList(ArrayList<Book> books) {
        ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this, android.R.layout.simple_expandable_list_item_1, books);
        ListView listView = (ListView)findViewById(R.id.list_books);
        listView.setAdapter(adapter);
    }
}
