package H2Database;

import H2Database.db_control.*;
import H2Database.db_model.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException{
        DBSource dbSource = DBSource.getConnection();
        dbSource.preload();

//        int coreCount = Runtime.getRuntime().availableProcessors();
//        ExecutorService services = Executors.newFixedThreadPool(coreCount-1);
//
//        Thread thread = new Thread(()->{
////            Customer customer = new Customer("5757281","Nghi Nguyen",17,"+1 (932) 586-3508","None","None");
//            ShoppingCart cart = new ShoppingCart();
//
//            cart.addToCartUsingISBN("1617291269");
//            cart.addToCartUsingISBN("193398886X");
//            cart.addToCartUsingISBN("1933988797");
//            cart.addToCartUsingISBN("1932394885");
//
////            cart.updateCartUsingTitle("iPhone in Action", 1);
//            dbSource.insertOrders("3434bb35f",cart);
//        });
//
//        for (int i = 0; i < 1; i++) {
//            services.submit(thread);
//        }
//        services.shutdown();
//
//        ResultSet resultSet = dbSource.getPurchaseHistory("3434bb35f");
//        System.out.println(resultSet.next());
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addToCartUsingISBN("1617291269");
        shoppingCart.addToCartUsingISBN("193398886X");
        shoppingCart.addToCartUsingISBN("1933988797");
        shoppingCart.addToCartUsingISBN("1932394885");

        Book book = new Book("1617291269");
        Book book1 = shoppingCart.getCurCart().entrySet().iterator().next().getKey();

        System.out.println(book);
        System.out.println(shoppingCart.isInCart("iOS in Practice"));

    }
}
