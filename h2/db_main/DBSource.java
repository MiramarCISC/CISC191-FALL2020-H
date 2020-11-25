package db_main;

import java.sql.*;


public class DBSource {
    public static final String URL = "jdbc:h2:file:./BooksDB";
    public static final String BOOKS_TABLE = "BOOKS";
    public static final String BOOKS_COLUMN_ISBN = "isbn";
    public static final String BOOKS_COLUMN_STOCK ="stock";
    public static final String ORDER_COLUMN_ID = "order_id";
    public static final String ORDER_COLUMN_CUSTOMERID ="customerid";
    public static final String ORDER_COLUMN_BOOKISBN = "bookisbn";
    public static final String ORDER_COLUMN_PRICE = "bookprice";




    private Connection con = null;
    private PreparedStatement queryInsertOrder;
    private static DBSource newCon = new DBSource();
    public static DBSource getConnection() {
        return newCon;
    }

    public boolean open() {
        try {
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection(URL, "sa", "");
            queryInsertOrder = con.prepareStatement("INSERT INTO ORDER VALUES ( ?,?,?,? )");


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
    public void close(){
        try{
            if(con!=null){
                con.close();
            }
        } catch (SQLException e){
            System.out.println("Error when closing Connection.. " +e.getMessage());
        }
    }
//    public Statement getStatement() throws SQLException {
//        return con.createStatement();
//        try {
//            return con.createStatement();
//        } catch (SQLException e) {
//            System.out.println("Cannot get Statement.. "+e.getMessage());
//        }
//    }



}
