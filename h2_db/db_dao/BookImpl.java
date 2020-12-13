/*
 * Contributors: Tu Hoang
 * */


package db_dao;
import db_model.Book;
import db_source.H2Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * This is the DAO concrete class with the purpose of inserting order history into BOOKS table.
 * */
public class BookImpl implements BookDao {
    public static final String BOOKS_COLUMN_ISBN = "isbn";
    public static final String BOOKS_COLUMN_STOCK = "stock";
    public static final String BOOKS_COLUMN_TITLE = "title";
    public static final String BOOKS_COLUMN_PUBLSIHEDDATE = "publishedDate";
    public static final String BOOKS_COLUMN_AUTHOR = "author";
    public static final String BOOKS_COLUMN_PRICE = "price";
    public static final String BOOKS_COLUMN_CATEGORY = "category";
    public static final String QUERY_BOOKS_INFO = "SELECT * FROM BOOKS";
    public static final String UPDATE_BOOKS_STOCK = "UPDATE BOOKS SET " + BOOKS_COLUMN_STOCK + " = " + BOOKS_COLUMN_STOCK +
            " - ? WHERE " + BOOKS_COLUMN_ISBN + " = ?";
    private PreparedStatement updateBookStocks;
    static Connection con = H2Connection.getConnection();

    private List<Book> bookList = new ArrayList<>();
    /*
     * This operation is to perform the select query that will retrieve all of the current books in the BOOKS table
     * and save them onto the bookList for GUI's randomization purpose.
     * */

    private boolean queryAllBooks() {
        Statement stm = null;
        try {
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(QUERY_BOOKS_INFO);
            while (rs.next()) {
                bookList.add(new Book(rs.getString(BOOKS_COLUMN_TITLE), rs.getString(BOOKS_COLUMN_ISBN),
                        rs.getDouble(BOOKS_COLUMN_PRICE), rs.getString(BOOKS_COLUMN_PUBLSIHEDDATE),
                        rs.getString(BOOKS_COLUMN_AUTHOR), rs.getString(BOOKS_COLUMN_CATEGORY)));
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't get the books data.. " + e.getMessage());
            return false;
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                System.out.println("Error when closing Statement.. " + e.getMessage());
            }
        }
    }
    /*
     * This method is to check if the query above actually works. When it does, returning the list of books.
     * */
    public List<Book> getAllBooks() {
        if (queryAllBooks()) {
            return this.bookList;
        } else
            return null;

    }



    /*
     * This a synchronized block that will perform the update operation towards the BOOKS table by executing the
     * update query through the PreparedStatement updateBookStocks. It will basically reduce
     * the stock number by the purchased amount, which is the input as list of items from the shopping cart.
     * */

    @Override
    public void changeStocks(List<Book> bookList) {
        synchronized (this) {
            bookList.forEach(book -> {
                try {
                    updateBookStocks = con.prepareStatement(UPDATE_BOOKS_STOCK);
                    updateBookStocks.setInt(1, book.getQuantity());
                    updateBookStocks.setString(2, book.getIsbn());
                    int modifiedRows = updateBookStocks.executeUpdate();
                    if (modifiedRows != 1) {
                        throw new SQLException("Something wrong happened when changing stock!");
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

            });
        }
        //For testing purpose
        System.out.println("Done changing stocks!");


    }
}
