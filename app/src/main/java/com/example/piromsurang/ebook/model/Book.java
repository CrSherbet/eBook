package com.example.piromsurang.ebook.model;

/**
 * Created by Piromsurang on 4/20/2017 AD.
 */

public class Book {
    private String title;
    private String id;
    private double price;
    private int pub_year;
    private String img_url;

    public Book(String title, String id, double price, int pub_year, String img_url) {
        this.title = title;
        this.id = id;
        this.price = price;
        this.pub_year = pub_year;
        this.img_url = img_url;
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

    public int getPubYear() {
        return pub_year;
    }

    public void setPubYear(int year) {
        this.pub_year = year;
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

    public String toString(){
        return "Title: " + title + "  Year: " + pub_year + "  \nPrice: " + price  ;
    }
}
