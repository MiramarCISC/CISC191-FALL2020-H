package db_dao;

import db_model.Customer;
import db_model.ShoppingCart;

public interface OrderHistoryDao {
    String insertOrders(Customer customer, ShoppingCart cart);
}
