/*
 * Contributors: Tu Hoang
 * */

package edu.sdccd.cisc191.h.db_dao;

import edu.sdccd.cisc191.h.db_model.Customer;

import java.sql.SQLException;


/*
 * This is DAO interface that defines operations to be performed on CUSTOMER table.
 * */

public interface CustomerDao {
    String insertCustomer(Customer customer) throws SQLException;
    boolean queryAllCustomers();
}
