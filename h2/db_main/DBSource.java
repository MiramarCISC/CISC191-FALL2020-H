package db_main;

import db_model.Book;
import db_model.Customer;
import db_model.ShoppingCart;

import java.sql.*;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;


public class DBSource {
    public static final String URL = "jdbc:h2:file:./BooksDB";
//    public static final String BOOKS_TABLE = "BOOKS";
//    public static final String BOOKS_COLUMN_ISBN = "isbn";
//    public static final String BOOKS_COLUMN_STOCK ="stock";
//    public static final String ORDERS_COLUMN_CUSTOMERID ="customerid";
//    public static final String ORDERS_COLUMN_ORDERID = "orderid";
//    public static final String ORDERS_COLUMN_DATE ="orderdate";
    public static final String CUSTOMER_COLUMN_CUSTOMERID = "customerid";
    public static final String CUSTOMER_COLUMN_NAME ="name";
    public static final String CUSTOMER_COLUMN_AGE = "age";
    public static final String CUSTOMER_COLUMN_EMAIL = "email";
    public static final String CUSTOMER_COLUMN_PHONE = "phone";
    public static final String CUSTOMER_COLUMN_ADDRESS = "address";
    public static final String ORDERITEMS_COLUMN_ORDERID = "orderid";
    public static final String ORDERITEMS_COLUMN_BOOKISBN = "isbn";
    public static final String ORDERITEMS_COLUMN_QUANTITY = "quantity";
    public static final String ORDERITEMS_COLUMN_PRICE = "price";




    private PreparedStatement queryCustomerInfo;
    private PreparedStatement insertIntoOrderItems;
    private PreparedStatement insertIntoCustomer;
    private PreparedStatement insertIntoOrders;


    public static final String QUERY_CUSTOMER_INFO = "SELECT * FROM CUSTOMER WHERE "+ CUSTOMER_COLUMN_CUSTOMERID+" = ?";
    public static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER VALUES (?,?,?,?,?,?)";

    public static final String INSERT_ORDERS = "INSERT INTO ORDERS VALUES (?,?,?)";
    public static final String INSERT_ORDERITEMS = "INSERT INTO ORDERITEMS("+ ORDERITEMS_COLUMN_ORDERID+", "+ ORDERITEMS_COLUMN_BOOKISBN+
                                                    ", "+ORDERITEMS_COLUMN_QUANTITY+", "+ORDERITEMS_COLUMN_PRICE+  ") VALUES (?,?,?,?)";








    private Connection con = null;
    private static DBSource newCon = new DBSource();
    public static DBSource getConnection() {
        return newCon;
    }

    public boolean open() {
        try {
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection(URL, "sa", "");
            queryCustomerInfo = con.prepareStatement(QUERY_CUSTOMER_INFO);
            insertIntoCustomer = con.prepareStatement(INSERT_CUSTOMER);
            insertIntoOrders = con.prepareStatement(INSERT_ORDERS);
            insertIntoOrderItems = con.prepareStatement(INSERT_ORDERITEMS);
            return true;
        } catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public void preload(){
        Statement stm = null;
        try {
            stm = con.createStatement();
            stm.executeUpdate("RUNSCRIPT FROM './Resources/preload.sql'");
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
            String newcustomerId = generateRandomID();
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

    private void insertOrderItems(String orderId, Map<Book, Integer> bookList) throws SQLException{
        Iterator<Map.Entry<Book,Integer>> itr = bookList.entrySet().iterator();
        int modifiedRows;
        Map.Entry<Book,Integer> bookEntry;
        while (itr.hasNext()){
            bookEntry = itr.next();

            insertIntoOrderItems.setString(1, orderId);
            insertIntoOrderItems.setString(2, bookEntry.getKey().getIsbn());
            insertIntoOrderItems.setInt(3, bookEntry.getValue());
            insertIntoOrderItems.setDouble(4, bookEntry.getKey().getPrice());
            modifiedRows = insertIntoOrderItems.executeUpdate();
            if(modifiedRows != 1) {
                throw new SQLException("Something wrong happened when inserting customer!");
            }
        }

    }

    //Start from here
    private void insertOrders(Customer customer, ShoppingCart cart){


        //saving order history
        try {
            con.setAutoCommit(false);
            String neworderId = generateRandomID();
            insertIntoOrders.setString(1, neworderId);
            insertIntoOrders.setString(2, insertCustomer(customer));
            insertIntoOrders.setDate(3, (Date) cart.getOrderedDate());
            int modifiedRows = insertIntoOrders.executeUpdate();
            if (modifiedRows == 1) {
                insertOrderItems(neworderId, cart.getCurCart());
                con.commit();
            } else{
                throw new SQLException("Something wrong happened when inserting order!");
            }
            //adding items into OrderItems

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

    public String generateRandomID(){
        return UUID.randomUUID().toString().split("-")[4];
    }


}
