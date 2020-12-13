/*
 * Contributors: Tu Hoang
 * */


package edu.sdccd.cisc191.h.db_dao;

import edu.sdccd.cisc191.h.db_model.Book;

import java.util.List;


/*
 * This is DAO interface that defines operations to be performed on BOOKS table.
 * */

public interface BookDao {
    List<Book> getAllBooks();
    void changeStocks(List<Book> bookList);
}
