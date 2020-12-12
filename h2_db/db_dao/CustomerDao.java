package db_dao;

import db_model.Customer;

import java.sql.SQLException;

public interface CustomerDao {
    String insertCustomer(Customer customer) throws SQLException;
}
