/*
 * Contributors: Tu Hoang
 * */


package db_dao;

import db_model.Book;

import java.util.List;


/*
 * This is DAO interface that defines operations to be performed on BOOKS table.
 * */

public interface BookDao {
    List<Book> getAllBooks();
    void changeStocks(List<Book> bookList);
}
