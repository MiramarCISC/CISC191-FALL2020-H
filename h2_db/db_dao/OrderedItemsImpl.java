
/*
 * Contributors: Tu Hoang
 * */
package db_dao;

import db_model.Book;
import db_source.H2Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/*
 * This is the DAO concrete class with the purpose of inserting ordered items into ORDEREDITEMS table.
 * */

public class OrderedItemsImpl implements OrderedItemsDao{
    public static final String ORDEREDITEMS_COLUMN_ORDERID = "orderid";
    public static final String ORDEREDITEMS_COLUMN_BOOKISBN = "isbn";
    public static final String ORDEREDITEMS_COLUMN_QUANTITY = "quantity";
    public static final String INSERT_ORDEREDITEMS = "INSERT INTO ORDEREDITEMS("+ ORDEREDITEMS_COLUMN_ORDERID+", "
                                                                                + ORDEREDITEMS_COLUMN_BOOKISBN+ ", "
                                                                                + ORDEREDITEMS_COLUMN_QUANTITY+") "
                                                                                + "VALUES (?,?,?)";
    static Connection con = H2Connection.getConnection();

    private PreparedStatement insertIntoOrderedItems;

    /*
     * This method will iterate through every item(book) in list of items from the shopping cart and then execute the
     * update query through the PreparedStatement insertIntoOrderedItems to insert all items(one by one) with respect
     * to their ids and quantities into the database with corresponding to only one order id.
     * */

    public void insertOrderedItems(String orderId, List<Book> bookList) throws SQLException {
        insertIntoOrderedItems = con.prepareStatement(INSERT_ORDEREDITEMS);
        Iterator<Book> itr = bookList.iterator();
        int modifiedRows;
        Book bookEntry;
        while (itr.hasNext()){
            bookEntry = itr.next();

            insertIntoOrderedItems.setString(1, orderId);
            insertIntoOrderedItems.setString(2, bookEntry.getIsbn());
            insertIntoOrderedItems.setInt(3, bookEntry.getQuantity());

            modifiedRows = insertIntoOrderedItems.executeUpdate();
            if(modifiedRows != 1) {
                throw new SQLException("Something wrong happened when inserting customer!");
            }
        }
    }

}
