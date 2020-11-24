package main_db;

import java.sql.*;

public class DBManagement implements BooksController{
    private static final String URL = "jdbc:h2:file:./BooksDB";
    private Connection con = null;
    private Statement stm = null;
    public DBManagement() {
        try {
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection(URL, "sa", "");
            stm = con.createStatement();
            preloadDB();
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("Cannot connect to database... " + e.getMessage());
        }
    }
    public void preloadDB(){
        //For a clean test
        try {
            this.stm.executeUpdate("RUNSCRIPT FROM './Resources/preload.sql'");
        } catch (SQLException ex) {
            System.out.println("Cannot pre-load the database... " + ex.getMessage());
        }
    }

    @Override
    public ResultSet selectBook() {
        return null;
    }
}
