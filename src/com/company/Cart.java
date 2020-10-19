package com.company;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

public class Cart extends ArrayList<Book>{
    private ArrayList<Book> booklist;
    public void addBook(Book book){
        if (book.getBookStock()<0)
            throw new IllegalArgumentException("Book is out of Stock");
        booklist.add(book);
    }
    public void removeBook(Book book){
        if (!booklist.contains(book))
            throw new IllegalArgumentException();
        for (Book book1 : booklist) {
            if (book.getBookID().equals(book1.getBookID()))
                booklist.remove(book);
        }
    }
}
