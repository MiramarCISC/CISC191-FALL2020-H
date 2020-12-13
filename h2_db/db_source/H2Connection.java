/*
 * Contributors: Tu Hoang
 **/

package db_source;
import java.sql.*;

/*
 * This is database connection class
 **/

public class H2Connection {
    public static final String URL = "jdbc:h2:file:./BooksDB";
    /*
    *  Creating the singleton instance
    **/
    private static Connection con = null;
    //Get the instance
    public static Connection getConnection() {
        return con;
    }
    private H2Connection(){}
    //Static constructor
    static {
        try {
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection(URL, "sa", "");
            preload();
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("Couldn't connect to the database " + e.getMessage());

        }
    }


    //Run the script to load the data and fill tables up before hand.
    private static void preload(){
        Statement stm = null;
        try {
            stm = con.createStatement();
            stm.executeUpdate("RUNSCRIPT FROM './Resources/data.sql'");

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

    //Shut down the connection.
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
