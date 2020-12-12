package db_source;

import db_model.Book;
import db_model.Customer;
import db_model.ShoppingCart;

import java.sql.*;
import java.util.*;


public class H2Connection {
    public static final String URL = "jdbc:h2:file:./BooksDB";
//    public static final String BOOKS_TABLE = "BOOKS";

    public static final String ORDERS_COLUMN_CUSTOMERID ="customerid";
    public static final String ORDERS_COLUMN_ORDERID = "orderid";
    public static final String ORDERS_COLUMN_DATE ="orderdate";

    public static final String CUSTOMER_COLUMN_NAME ="name";
    public static final String CUSTOMER_COLUMN_AGE = "age";
    public static final String CUSTOMER_COLUMN_EMAIL = "email";
    public static final String CUSTOMER_COLUMN_PHONE = "phone";
    public static final String CUSTOMER_COLUMN_ADDRESS = "address";







    /*
        Creating the singleton instance
    */
    private static Connection con = null;
    public static Connection getConnection() {
        return con;
    }
    private H2Connection(){}
    static {
        try {
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection(URL, "sa", "");
            preload();
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("Couldn't connect to the database " + e.getMessage());

        }
    }
    /*****************************************************************************************/



    private static void preload(){
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


    public static void close(){
        try{
            if(con!=null){
                con.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e){
            System.out.println("Error when closing Connection.. " +e.getMessage());
        }
    }

}
