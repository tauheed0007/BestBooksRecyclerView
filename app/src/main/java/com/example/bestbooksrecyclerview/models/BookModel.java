package com.example.bestbooksrecyclerview.models;

public class BookModel {
    String image;
    String bookName;
    String url;

    public BookModel(String image, String bookName, String url) {
        this.image = image;
        this.bookName = bookName;
        this.url = url;
    }

    public BookModel(){}

    public String getImage() {
        return image;
    }

    public String getBookName() {
        return bookName;
    }

    public String getUrl() {
        return url;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}



/*

    public BookModel(int image, String bookName) {
        this.image = image;
        this.bookName = bookName;
    }

    public int getImage() {
        return image;
    }

    public String getBookName() {
        return bookName;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
*/
