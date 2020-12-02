package db_main;

import db_model.Book;
import db_model.Customer;
import db_model.ShoppingCart;

import java.sql.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;


public class DBSource {
    public static final String URL = "jdbc:h2:file:./BooksDB";
//    public static final String BOOKS_TABLE = "BOOKS";
    public static final String BOOKS_COLUMN_ISBN = "isbn";
    public static final String BOOKS_COLUMN_TITLE ="title";
    public static final String BOOKS_COLUMN_PUBLSIHEDDATE = "publishedDate";
    public static final String BOOKS_COLUMN_AUTHOR = "author";
    public static final String BOOKS_COLUMN_PRICE = "price";
    public static final String BOOKS_COLUMN_CATEGORY = "category";
    public static final String ORDERS_COLUMN_CUSTOMERID ="customerid";
    public static final String ORDERS_COLUMN_ORDERID = "orderid";
    public static final String ORDERS_COLUMN_DATE ="orderdate";
    public static final String CUSTOMER_COLUMN_CUSTOMERID = "customerid";
    public static final String CUSTOMER_COLUMN_NAME ="name";
    public static final String CUSTOMER_COLUMN_AGE = "age";
    public static final String CUSTOMER_COLUMN_EMAIL = "email";
    public static final String CUSTOMER_COLUMN_PHONE = "phone";
    public static final String CUSTOMER_COLUMN_ADDRESS = "address";
    public static final String ORDEREDITEMS_COLUMN_ORDERID = "orderid";
    public static final String ORDEREDITEMS_COLUMN_BOOKISBN = "isbn";
    public static final String ORDEREDITEMS_COLUMN_QUANTITY = "quantity";



    private PreparedStatement queryCustomerInfo;
    private PreparedStatement insertIntoOrderedItems;
    private PreparedStatement insertIntoCustomer;
    private PreparedStatement insertIntoOrders;
    private Statement queryBooksInfo;

    public static final String QUERY_CUSTOMER_INFO = "SELECT * FROM CUSTOMER WHERE "+ CUSTOMER_COLUMN_CUSTOMERID+" = ?";
    public static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER VALUES (?,?,?,?,?,?)";
    public static final String QUERY_BOOKS_INFO = "SELECT * FROM BOOKS";
    public static final String INSERT_ORDERS = "INSERT INTO ORDERS VALUES (?,?,?)";
    public static final String INSERT_ORDEREDITEMS = "INSERT INTO ORDEREDITEMS("+ ORDEREDITEMS_COLUMN_ORDERID+", "
                                                                                + ORDEREDITEMS_COLUMN_BOOKISBN+ ", "
                                                                                + ORDEREDITEMS_COLUMN_QUANTITY+") "
                                                                                + "VALUES (?,?,?)";








    private Connection con = null;
    private List<Book> bookData = new ArrayList<>();
    private static DBSource newCon = new DBSource();
    public static DBSource getConnection() {
        return newCon;
    }
     private DBSource(){

     }

    public boolean open() {
        try {
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection(URL, "sa", "");
            preload();
            queryCustomerInfo = con.prepareStatement(QUERY_CUSTOMER_INFO);
            insertIntoCustomer = con.prepareStatement(INSERT_CUSTOMER);
            insertIntoOrders = con.prepareStatement(INSERT_ORDERS);
            insertIntoOrderedItems = con.prepareStatement(INSERT_ORDEREDITEMS);
            queryBooksInfo = con.createStatement();
            return true;
        } catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public ResultSet getBooksInfo() throws SQLException {
        return this.queryBooksInfo.executeQuery(QUERY_BOOKS_INFO);
    }
    private void preload(){
        Statement stm = null;
        try {
            stm = con.createStatement();
            stm.executeUpdate("RUNSCRIPT FROM './Resources/preload.sql'");
            ResultSet rs = stm.executeQuery(QUERY_BOOKS_INFO);
            while (rs.next()){
                this.bookData.add(new Book(rs.getString(BOOKS_COLUMN_TITLE),rs.getString(BOOKS_COLUMN_ISBN),
                                            rs.getDouble(BOOKS_COLUMN_PRICE), rs.getString(BOOKS_COLUMN_PUBLSIHEDDATE),
                                            rs.getString(BOOKS_COLUMN_AUTHOR), rs.getString(BOOKS_COLUMN_CATEGORY)));
            }

        }
        catch (SQLException e){
            System.out.println("Cannot preload the databse.. " + e.getMessage());
        } finally {
            try {
                if(stm!=null){
                    stm.close();
                }
            }catch (SQLException e){
                System.out.println("Error when closing Statement.. " + e.getMessage());
            }
        }
    }

    //inserting a new customer and returning the new id
    private String insertCustomer(Customer customer) throws SQLException {
        queryCustomerInfo.setString(1, customer.getcId());
        ResultSet rs = queryCustomerInfo.executeQuery();
        if(!rs.next()){
            String newcustomerId = customer.getcId();
            insertIntoCustomer.setString(1, newcustomerId);
            insertIntoCustomer.setString(2, customer.getcName());
            insertIntoCustomer.setInt(3, customer.getcAge());
            insertIntoCustomer.setString(4, customer.getcEmail());
            insertIntoCustomer.setString(5, customer.getcPhone());
            insertIntoCustomer.setString(6, customer.getcAddress());
            int modifiedRows = insertIntoCustomer.executeUpdate();
            if(modifiedRows != 1) {
                throw new SQLException("Something wrong happened when inserting customer!");
            }
            return newcustomerId;
        } else {
            return rs.getString(CUSTOMER_COLUMN_CUSTOMERID);
        }

    }


    //TESTING THIS IF POSSIBLE !!!!!!!!!!!!!!!

    private void insertOrderedItems(String orderId, List<Book> bookList) throws SQLException{
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

    //Start from here
    public void insertOrders(Customer customer, ShoppingCart cart){


        //saving order history
        try {
            con.setAutoCommit(false);
            String neworderId = generateRandomID();
            insertIntoOrders.setString(1, neworderId);
            insertIntoOrders.setString(2, insertCustomer(customer));
            insertIntoOrders.setObject(3, cart.getOrderedDate());
            int modifiedRows = insertIntoOrders.executeUpdate();
            if (modifiedRows == 1) {
                insertOrderedItems(neworderId, cart.getCurCart());
                con.commit();
            } else{
                throw new SQLException("Something wrong happened when inserting order!");
            }

        } catch (SQLException e){
            System.out.println("Insert into ORDERS failed!");
            try{
                System.out.println("Rolling back... " + e.getMessage());
                con.rollback();
            } catch (SQLException e2){
                System.out.println("Couldn't roll back, RIP "+ e2.getMessage());
            }
        } finally {
            try{
                System.out.println("Resetting auto-commit...");
                con.setAutoCommit(true);
            } catch (SQLException e3){
                System.out.println("Couldn't reset auto-commit ! " + e3.getMessage());
            }
        }


    }
    public void close(){
        try{
            if(con!=null){
                con.close();
            }
        } catch (SQLException e){
            System.out.println("Error when closing Connection.. " +e.getMessage());
        }
    }

    private String generateRandomID(){
        return UUID.randomUUID().toString().split("-")[4];
    }

    public List<Book> getBookData() {
        return this.bookData;
    }
}
