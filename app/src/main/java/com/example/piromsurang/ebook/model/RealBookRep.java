package com.example.piromsurang.ebook.model;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by waris on 4/26/2017.
 */

public class RealBookRep extends Observable implements Repository {
    private ArrayList<Book> books;
    private static RealBookRep instance = null;

    private RealBookRep() {
        books = new ArrayList<Book>();
        loadData();
    }

    public static RealBookRep getInstance() {
        if( instance == null )
            instance = new RealBookRep();
        return instance;
    }
    public void loadData(){
        BookFetcherTask task = new BookFetcherTask();
        task.execute();
    }

    public class BookFetcherTask extends AsyncTask<Void,Void, ArrayList<Book>> {

        @Override
        protected ArrayList<Book> doInBackground(Void... params){
            String bookListJsonStr = loadBookJson();
            if(bookListJsonStr.equals(""))
                return null;
            ArrayList<Book> result = new ArrayList<>();
            try {
                JSONArray array = new JSONArray(bookListJsonStr);
                for(int i=0; i<array.length(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    Book book = new Book(jsonObject.getString("title"),
                            jsonObject.getString("id"), jsonObject.getDouble("price"), jsonObject.getInt("pub_year"), jsonObject.getString("img_url"));
                    result.add(book);
                }

            } catch(JSONException e){
                return null;
            }
            return result;

        }

        private String loadBookJson(){
            String result = "";
            try {
                URL bookUrl  = new URL("https://theory.cpe.ku.ac.th/~jittat/courses/sw-spec/ebooks/books.json");
                URLConnection connection = bookUrl.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader( connection.getInputStream()));
                String inputLine;
                while((inputLine = in.readLine()) != null){
                    result += inputLine;
                }
                return result;

            } catch (IOException e) {
                return result;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<Book> result){
            if(result != null){
                books.clear();
                for(Book b: result){
                    books.add(b);
                }
            }
            setChanged();
            notifyObservers();
        }
    }

    public ArrayList<Book> search(String type ,String text){
        ArrayList<Book> result = new ArrayList<Book>();
        if(type.equals("Title")) {
            for (Book b : books) {
                if (b.getTitle().contains(text)) {
                    result.add(b);
                }
            }
        } else {
            for (Book b : books) {
                if((b.getPubYear()+"").contains(text)) {
                    result.add(b);
                }
            }
        }
        return result;
    }

    @Override
    public ArrayList<Book> getBookList() {
        return books;
    }
}
