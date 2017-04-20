package com.example.piromsurang.ebook.model;

/**
 * Created by Piromsurang on 4/20/2017 AD.
 */

public class Book {

    private double price;
    private String img_url;
    private String id;
    private String title;

    public Book( double price, String img_url, String id, String title ) {
        this.price = price;
        this.img_url = img_url;
        this.id = id;
        this.title = title;
    }
}
