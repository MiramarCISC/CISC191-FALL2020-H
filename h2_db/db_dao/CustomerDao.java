/*
 * Contributors: Tu Hoang
 * */

package db_dao;

import db_model.Customer;

import java.sql.SQLException;


/*
 * This is DAO interface that defines operations to be performed on CUSTOMER table.
 * */

public interface CustomerDao {
    String insertCustomer(Customer customer) throws SQLException;
    boolean queryAllCustomers();
}
