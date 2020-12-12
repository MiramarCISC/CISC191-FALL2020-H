package db_dao;

import db_model.Customer;
import db_source.H2Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CusDaoImpl implements CustomerDao{

    public static final String CUSTOMER_COLUMN_CUSTOMERID = "customerid";
    public static final String CUSTOMER_COLUMN_NAME ="name";
    public static final String CUSTOMER_COLUMN_AGE = "age";
    public static final String CUSTOMER_COLUMN_EMAIL ="email";
    public static final String CUSTOMER_COLUMN_PHONE = "phone";
    public static final String CUSTOMER_COLUMN_ADDRESS = "address";
    //public static final String QUERY_CUSTOMER_INFO = "SELECT * FROM CUSTOMER WHERE "+ CUSTOMER_COLUMN_CUSTOMERID+" = ?";
    public static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER VALUES (?,?,?,?,?,?)";
    public static final String QUERY_CUSTOMERS_INFO = "SELECT * FROM CUSTOMER";



    static Connection con = H2Connection.getConnection();

    //private PreparedStatement queryCustomerInfo;

    private PreparedStatement insertIntoCustomer;

    private List<Customer> customersList = new ArrayList<>();


    public String insertCustomer(Customer customer) throws SQLException{
        insertIntoCustomer = con.prepareStatement(INSERT_CUSTOMER);

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
    }
    public List<Customer> getCustomersList(){
        if(queryAllCustomers()){
            return this.customersList;
        } else
            return null;

    }


    private boolean queryAllCustomers() {
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
