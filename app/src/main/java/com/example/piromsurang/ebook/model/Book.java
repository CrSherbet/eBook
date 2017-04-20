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

    public double getPrice() {
        return price;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImg_url(String url) {
        this.img_url = url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
