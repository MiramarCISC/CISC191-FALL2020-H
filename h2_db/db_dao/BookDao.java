package db_dao;

import db_model.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBooks();
    void changeStocks(List<Book> bookList);
}
