package H2Database;

import H2Database.db_control.*;
import H2Database.db_model.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws SQLException{
        DBSource dbSource = DBSource.getConnection();
        dbSource.preload();
//        int modifiedRow;
//        int modifiedRow1;
//        String sqlStock = DBSource.UPDATE_STOCK;
//        String sqlItem = DBSource.INSERT_ORDER_ITEMS;
//        try(PreparedStatement updateStock = DBSource.open().prepareStatement(sqlStock);
//            PreparedStatement insertItems = DBSource.open().prepareStatement(sqlItem)){
//            updateStock.setString(1,"1617291212");
//            updateStock.setInt(2,10);
//            updateStock.setString(3,"1617291212");
//
//            insertItems.setString(1,"ff653cc3df4f");
//            insertItems.setString(2,"1617291212");
//            insertItems.setInt(3,10);
//
//            modifiedRow = updateStock.executeUpdate();
//            modifiedRow1 = insertItems.executeUpdate();
//            System.out.println(modifiedRow);
//            System.out.println(modifiedRow1);
//        }


        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService services = Executors.newFixedThreadPool(coreCount-1);

        Thread thread = new Thread(()->{
            ShoppingCart cart = new ShoppingCart();

//            cart.updateCartUsingISBN("1617291269",12);
//            cart.updateCartUsingISBN("1617291269",1);
//            cart.updateCartUsingISBN("193398886X",19);

//            dbSource.insertOrders("3434bb35f",cart);
        });

        for (int i = 0; i < 1; i++) {
            services.submit(thread);
        }
        services.shutdown();

//        ResultSet resultSet = dbSource.getPurchaseHistory("3434bb35f");
//        System.out.println(resultSet.next());
//        ShoppingCart shoppingCart = new ShoppingCart();
//        shoppingCart.addToCartUsingISBN("1617291269");
//        shoppingCart.addToCartUsingISBN("193398886X");
//        shoppingCart.addToCartUsingISBN("1933988797");
//        shoppingCart.addToCartUsingISBN("1932394885");
//
//        Book book = new Book("1617291269");
//        Book book1 = shoppingCart.getCurCart().entrySet().iterator().next().getKey();
//
//        System.out.println(book);
//        System.out.println(shoppingCart.isInCart("iOS in Practice"));

    }
}
