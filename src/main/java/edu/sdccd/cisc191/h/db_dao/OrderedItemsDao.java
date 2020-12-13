/*
 * Contributors: Tu Hoang
 * */
package edu.sdccd.cisc191.h.db_dao;

import edu.sdccd.cisc191.h.db_model.Book;

import java.sql.SQLException;
import java.util.List;
/*
 * This is DAO interface that defines operations to be performed on ORDEREDITEMS table.
 * */

public interface OrderedItemsDao {
    void insertOrderedItems(String orderId, List<Book> bookList) throws SQLException;
}
