package db_dao;

import db_model.Book;

import java.sql.SQLException;
import java.util.List;

public interface OrderedItemsDao {
    void insertOrderedItems(String orderId, List<Book> bookList) throws SQLException;
}
