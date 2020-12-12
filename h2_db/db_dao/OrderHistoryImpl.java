package db_dao;

import db_model.Customer;
import db_model.ShoppingCart;
import db_source.H2Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class OrderHistoryImpl implements OrderHistoryDao{
    static Connection con = H2Connection.getConnection();
    public static final String INSERT_ORDERS = "INSERT INTO ORDERS VALUES (?,?,?)";
    private PreparedStatement insertIntoOrders;
    private OrderedItemsImpl orderedItemsImpl = new OrderedItemsImpl();

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
