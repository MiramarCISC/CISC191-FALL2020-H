/*
 * Contributors: Tu Hoang
 * */

package db_dao;

import db_model.Customer;
import db_source.H2Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/*
 * This is the DAO concrete class with the purpose of inserting order history into CUSTOMER table.
 * */

public class CustomerImpl implements CustomerDao{

    public static final String CUSTOMER_COLUMN_CUSTOMERID = "customerid";
    public static final String CUSTOMER_COLUMN_NAME ="name";
    public static final String CUSTOMER_COLUMN_AGE = "age";
    public static final String CUSTOMER_COLUMN_EMAIL ="email";
    public static final String CUSTOMER_COLUMN_PHONE = "phone";
    public static final String CUSTOMER_COLUMN_ADDRESS = "address";
    public static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER VALUES (?,?,?,?,?,?)";
    public static final String QUERY_CUSTOMERS_INFO = "SELECT * FROM CUSTOMER";



    static Connection con = H2Connection.getConnection();


    private PreparedStatement insertIntoCustomer;

    private List<Customer> customersList = new ArrayList<>();

    /*
     * This operation will insert a customer into the CUSTOMER table with a parameter as a customer object.
     * It will execute the update query through the PreparedStatement insertIntoCustomer.
     * Finally, it will return the id of the customer just inserted.
     * */

    public String insertCustomer(Customer customer) throws SQLException{
        insertIntoCustomer = con.prepareStatement(INSERT_CUSTOMER);
        insertIntoCustomer.setString(1, customer.getcId());
        insertIntoCustomer.setString(2, customer.getcName());
        insertIntoCustomer.setInt(3, customer.getcAge());
        insertIntoCustomer.setString(4, customer.getcEmail());
        insertIntoCustomer.setString(5, customer.getcPhone());
        insertIntoCustomer.setString(6, customer.getcAddress());
        int modifiedRows = insertIntoCustomer.executeUpdate();
        if(modifiedRows != 1) {
            throw new SQLException("Something wrong happened when inserting customer!");
        }
        return customer.getcId();
    }

    /*
     * This method is to check if the query below actually works. When it does, returning the list of customers.
     * */

    public List<Customer> getCustomersList(){
        if(queryAllCustomers()){
            return this.customersList;
        } else
            return null;

    }

    /*
     * This operation is to perform the select query that will retrieve all of the current customers in the CUSTOMER table
     * and save them onto the customersList for GUI's randomization purpose.
     * */


    public boolean queryAllCustomers() {
        Statement stm = null;
        try {
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(QUERY_CUSTOMERS_INFO);
            while (rs.next()) {
                customersList.add(new Customer(rs.getString(CUSTOMER_COLUMN_CUSTOMERID), rs.getString(CUSTOMER_COLUMN_NAME),
                        rs.getInt(CUSTOMER_COLUMN_AGE), rs.getString(CUSTOMER_COLUMN_EMAIL), rs.getString(CUSTOMER_COLUMN_PHONE),
                        rs.getString(CUSTOMER_COLUMN_ADDRESS)));
            }
            return true;
        } catch (SQLException e){
            System.out.println("Couldn't get the customers data.. " + e.getMessage());
            return false;
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
}
