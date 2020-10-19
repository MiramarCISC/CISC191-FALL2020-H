package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class Book{
    private String bookID;
    private String bookTitle;
    private String bookAuthor;
    private String bookEdition;
    private AtomicInteger bookStock = new AtomicInteger(); // Need to synchronize this

    public Book(String bookID, String bookTitle, String bookAuthor, String bookEdition, int bookStock) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookEdition = bookEdition;
        this.bookStock.set(bookStock);
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(String bookEdition) {
        this.bookEdition = bookEdition;
    }

    public int getBookStock() {
        return bookStock.get();
    }

    public void setBookStock(int bookStock) {
        this.bookStock.set(bookStock);
    }

    public void checkOut(int bookStock){
        this.bookStock.addAndGet(-1*bookStock);
    }
}