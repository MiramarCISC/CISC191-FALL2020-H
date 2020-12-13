/*
* Contributors: Tu Hoang
* */

package db_dao;

import db_model.Customer;
import db_model.ShoppingCart;

/*
 * This is DAO interface that defines operations to be performed on ORDERS table.
 * */

public interface OrderHistoryDao {
    String insertOrders(Customer customer, ShoppingCart cart);

}
