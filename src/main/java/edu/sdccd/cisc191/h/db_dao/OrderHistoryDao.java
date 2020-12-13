/*
* Contributors: Tu Hoang
* */

package edu.sdccd.cisc191.h.db_dao;

import edu.sdccd.cisc191.h.db_model.Customer;
import edu.sdccd.cisc191.h.db_model.ShoppingCart;

/*
 * This is DAO interface that defines operations to be performed on ORDERS table.
 * */

public interface OrderHistoryDao {
    String insertOrders(Customer customer, ShoppingCart cart);

}
