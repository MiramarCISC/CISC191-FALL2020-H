package db_dao;
import db_model.Book;
import db_source.H2Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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

    public List<Book> getAllBooks() {
        if (queryAllBooks()) {
            return this.bookList;
        } else
            return null;

    }

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
        System.out.println("Done changing stocks!");
        System.out.println("Disconnecting the server!");
        H2Connection.close();
    }
}
