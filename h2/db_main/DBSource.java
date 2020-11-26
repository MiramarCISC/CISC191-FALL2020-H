package db_main;

import db_model.Book;
import db_model.Customer;
import db_model.ShoppingCart;

import java.sql.*;
import java.util.Map;
import java.util.UUID;
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
            //queryInsertOrders = con.prepareStatement("INSERT INTO ORDERS VALUES ( ?,?,?,? )");
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
            int flag = insertIntoCustomer.executeUpdate();
            if(flag != 1) {
                throw new SQLException("Couldn't insert customer!");
            }
            return newcustomerId;
        } else {
            return rs.getString(CUSTOMER_COLUMN_CUSTOMERID);
        }

    }


    private void insertOrderItems(String orderId, Map<Book, Integer> booklist){
        booklist.forEach((key, value) -> {
            try {
                insertIntoOrderItems.setString(1, orderId);
                insertIntoOrderItems.setString(2, key.getIsbn());
                insertIntoOrderItems.setInt(3, value);
                insertIntoOrderItems.setDouble(4, key.getPrice());
                insertIntoOrderItems.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Cannot insert item into ORDERITEMS" + e.getMessage());
            }

        });


    }

    //Start from here
    private void insertOrders(Customer customer, ShoppingCart cart) throws SQLException {


        //saving order history
        String neworderId = generateRandomID();
        insertIntoOrders.setString(1, neworderId);
        insertIntoOrders.setString(2, insertCustomer(customer));
        insertIntoOrders.setDate(3, (Date) cart.getOrderedDate());
        int flag = insertIntoOrders.executeUpdate();
        if(flag != 1) {
            throw new SQLException("Couldn't insert new order!");
        }
        //adding items into OrderItems
        insertOrderItems(neworderId, cart.getCurCart());


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
