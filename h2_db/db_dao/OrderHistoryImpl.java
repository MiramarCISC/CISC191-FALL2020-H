/*
 * Contributors: Tu Hoang
 * */

package db_dao;

import db_model.Customer;
import db_model.ShoppingCart;
import db_source.H2Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/*
 * This is the DAO concrete class with the purpose of inserting order history into ORDERS table.
 * */

public class OrderHistoryImpl implements OrderHistoryDao{
    static Connection con = H2Connection.getConnection();
    public static final String INSERT_ORDERS = "INSERT INTO ORDERS VALUES (?,?,?)";
    private PreparedStatement insertIntoOrders;
    private OrderedItemsImpl orderedItemsImpl = new OrderedItemsImpl();

    /*
     * This operation will first turn off auto-commit, and generate new Id for the order.
     * After that, it will execute the update query through the PreparedStatement insertIntoOrders with values as the order id,
     * the customer id, and the date. The order id and customer id pair is unique.
     * Next, if everything goes well, it will then call the operation insertOrderedItems from OrderedItemsImpl DAO concrete class.
     * Then, if it is successfully inserted, the operation will commit the changes towards the database.
     * Finally, it will return the auto-commit back to 'ON', which means true.
     * If exceptions occur, it will call the rollback method to make sure no changes have been actually made.
     * */

    public String insertOrders(Customer customer, ShoppingCart cart){
        try {
            insertIntoOrders = con.prepareStatement(INSERT_ORDERS);
            con.setAutoCommit(false);
            String newOrderId = UUID.randomUUID().toString().split("-")[4];
            insertIntoOrders.setString(1, newOrderId);
            insertIntoOrders.setString(2, customer.getcId());
            insertIntoOrders.setObject(3, cart.getOrderedDate());
            int modifiedRows = insertIntoOrders.executeUpdate();
            if (modifiedRows == 1) {
                orderedItemsImpl.insertOrderedItems(newOrderId, cart.getCurCart());
                con.commit();
            } else{
                throw new SQLException("Something wrong happened when inserting order!");
            }
            return newOrderId;
        } catch (SQLException e){
            System.out.println("Insert into ORDERS failed!");
            try{
                System.out.println("Rolling back... " + e.getMessage());
                con.rollback();
                return null;
            } catch (SQLException e2){
                System.out.println("Couldn't roll back, RIP "+ e2.getMessage());
            }
        } finally {
            try{
                System.out.println("Resetting auto-commit...");
                con.setAutoCommit(true);
            } catch (SQLException e3){
                System.out.println("Couldn't reset auto-commit ! " + e3.getMessage());
            }
        }
        return null;
    }

}
