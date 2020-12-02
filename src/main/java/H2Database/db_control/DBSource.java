package H2Database.db_control;

import H2Database.db_model.Book;
import H2Database.db_model.Customer;
import H2Database.db_model.ShoppingCart;
import H2Database.functionality.Logging;

import java.sql.*;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;


public class DBSource {
//    public static final String CUSTOMER_COLUMN_NAME = "name";
//    public static final String CUSTOMER_COLUMN_AGE = "age";
//    public static final String CUSTOMER_COLUMN_EMAIL = "email";
//    public static final String CUSTOMER_COLUMN_PHONE = "phone";
//    public static final String CUSTOMER_COLUMN_ADDRESS = "address";
//    public static final String ORDERITEMS_COLUMN_ORDERID = "order_id";
//    public static final String ORDERITEMS_COLUMN_BOOKISBN = "isbn";
//    public static final String ORDERITEMS_COLUMN_QUANTITY = "quantity";
//    public static final String ORDERITEMS_COLUMN_PRICE = "price";

    public static final String URL = "jdbc:h2:~/test;";
    private final static String USERNAME = "sa";
    private final static String PASSWORD = "";

    public static final String CUSTOMER_COLUMN_CUSTOMERID = "customer_id";
    public static final String BOOK_COLUMN_STOCK = "stock";
    public static final String BOOK_COLUMN_ISBN = "isbn";

    public static final String QUERY_CUSTOMER_INFO = "SELECT * FROM CISC191.CUSTOMERS WHERE " + CUSTOMER_COLUMN_CUSTOMERID + " = ?";
    public static final String QUERY_BOOKS_INFO = "SELECT * FROM CISC191.BOOKS WHERE " + BOOK_COLUMN_ISBN + " = ?";
    public static final String INSERT_CUSTOMER = "INSERT INTO CISC191.CUSTOMERS VALUES (?,?,?,?,?,?)";
    public static final String INSERT_ORDERS = "INSERT INTO CISC191.ORDERS VALUES (?,?,?)";
    public static final String INSERT_ORDERITEMS = "INSERT INTO CISC191.ORDER_ITEMS VALUES (?,?,?)";
    public static final String UPDATE_BOOKS_STOCK = "UPDATE CISC191.BOOKS SET " + BOOK_COLUMN_STOCK + " = ? WHERE " + BOOK_COLUMN_ISBN + " = ?";

    private final static Logger logger = Logging.getLogger();

    private PreparedStatement queryInfo;
    private PreparedStatement insertIntoOrderItems;
    private PreparedStatement insertIntoCustomer;
    private PreparedStatement insertIntoOrders;

    public static DBSource getConnection() {
        return new DBSource();
    }


    public static Connection open() {
        Connection connection;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            logger.severe(e.getMessage());
            return null;
        }
    }

    public static void close() {
        Connection con = open();
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
            logger.severe("Close Connection Failed: " + e.getMessage());
        }
    }

    public void preload() {
        String preloadPath = System.getProperty("user.dir") + "/src/main/resources/preload.sql";
        try (Connection connection = DBSource.open();
             Statement statement = connection.createStatement()) {
            logger.info("Connected");
            statement.executeUpdate("RUNSCRIPT FROM '" + preloadPath + "'");
            logger.info("Built");

        } catch (SQLException e) {
            logger.severe("Preload Databse Failed: " + e.getMessage());
        }
    }

    //inserting a new customer and returning the new id
    private String insertCustomer(Customer customer, Connection connection) throws SQLException {


        insertIntoCustomer = connection.prepareStatement(INSERT_CUSTOMER);
        int modifiedRows;
        String returnValue;
        ResultSet rs = queryINFO(QUERY_CUSTOMER_INFO, customer.getcId());

        if (!rs.next()) {
            String newcustomerId = generateRandomID();
            insertIntoCustomer.setString(1, newcustomerId);
            insertIntoCustomer.setString(2, customer.getcName());
            insertIntoCustomer.setInt(3, customer.getcAge());
            insertIntoCustomer.setString(4, customer.getcEmail());
            insertIntoCustomer.setString(5, customer.getcPhone());
            insertIntoCustomer.setString(6, customer.getcAddress());
            modifiedRows = insertIntoCustomer.executeUpdate();
            if (modifiedRows != 1)
                throw new SQLException("Insert Into CUSTOMERS Failed!!!");
            returnValue = newcustomerId;
        } else
            returnValue = rs.getString(CUSTOMER_COLUMN_CUSTOMERID);
        return returnValue;
    }

    private void insertOrderItems(String orderId, Map<Book, Integer> bookList, Connection connection) throws SQLException {

        Iterator<Map.Entry<Book, Integer>> itr = bookList.entrySet().iterator();
        int modifiedRows;
        int quantity;
        String isbn;
        Map.Entry<Book, Integer> bookEntry;
        insertIntoOrderItems = connection.prepareStatement(INSERT_ORDERITEMS);

        while (itr.hasNext()) {
            bookEntry = itr.next();
            quantity = bookEntry.getValue();
            isbn = bookEntry.getKey().getIsbn();

            updateStock(isbn, quantity, connection);

            insertIntoOrderItems.setString(1, orderId);
            insertIntoOrderItems.setString(2, isbn);
            insertIntoOrderItems.setInt(3, quantity);

            modifiedRows = insertIntoOrderItems.executeUpdate();
            if (modifiedRows != 1) {
                throw new SQLException("Insert Into ORDER_ITEMS Failed!!!");
            }
        }

    }

    public void insertOrders(Customer customer, ShoppingCart cart) {
        Connection connection = DBSource.open();

        try {
            insertIntoOrders = connection.prepareStatement(INSERT_ORDERS);
            connection.setAutoCommit(false);

            String newOrderId = generateRandomID()+"OD";
            insertIntoOrders.setString(1, newOrderId);
            insertIntoOrders.setString(2, insertCustomer(customer, connection));
            insertIntoOrders.setDate(3, (Date) cart.getOrderedDate());

            int modifiedRows = insertIntoOrders.executeUpdate();
            if (modifiedRows == 1) {
                insertOrderItems(newOrderId, cart.getCurCart(), connection);
                connection.commit();
            } else {
                throw new SQLException("Insert Order Failed!!!");
            }
            logger.info("Added Order: "+newOrderId);
            //adding items into OrderItems

        } catch (SQLException e) {
            logger.severe("Insert Into ORDERS Failed!!!");
            try {
                logger.info("Rolling back... " + e.getMessage());
                connection.rollback();
            } catch (SQLException e2) {
                logger.severe("Roll back Failed: " + e2.getMessage());
            }
        } finally {
            try {
                logger.info("Resetting auto-commit...");
                connection.setAutoCommit(true);
                DBSource.close();
            } catch (SQLException e3) {
                logger.severe("Reset Auto-commit Failed: " + e3.getMessage());
            }
        }


    }
    public void updateStock(String isbn, int requestedStock, Connection connection) throws SQLException {
        ResultSet resultSet = queryINFO(QUERY_BOOKS_INFO, isbn);
        resultSet.next();
        int availableStock = resultSet.getInt(BOOK_COLUMN_STOCK);
        PreparedStatement updateBookStock = connection.prepareStatement(UPDATE_BOOKS_STOCK);

        updateBookStock.setInt(1, availableStock - requestedStock);
        updateBookStock.setString(2, isbn);
        if (updateBookStock.executeUpdate() != 1)
            throw new SQLException("Updated Stock Failed!!!");

    }


    private ResultSet queryINFO(String query, String key) {
        Connection connection = DBSource.open();
        ResultSet resultSet = null;
        try {
            queryInfo = connection.prepareStatement(query);
            queryInfo.setString(1, key);
            resultSet = queryInfo.executeQuery();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            DBSource.close();
        }
        return resultSet;
    }

    private String generateRandomID() {
        return UUID.randomUUID().toString().split("-")[4];
    }


}
