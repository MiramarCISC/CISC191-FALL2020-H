package H2Database;

import H2Database.db_control.*;
import H2Database.db_model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    public static void main(String[] args) throws SQLException{
        DBSource dbSource = DBSource.getConnection();
        dbSource.preload();

        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService services = Executors.newFixedThreadPool(coreCount-1);

        Thread thread = new Thread(()->{
//            Customer customer = new Customer("5757281","Nghi Nguyen",17,"+1 (932) 586-3508","None","None");
            ShoppingCart cart = new ShoppingCart();
            cart.updateCart(new Book("1617291269",
                            "iOS in Practice",
                            72.083,
                            1,
                            "2013-11-01",
                            "Bear P. Cahill",
                            "Mobile Technology"),
                    1);

            cart.updateCart(new Book("193398886X",
                            "iPhone in Action",
                            74.750,19,
                            "2008-12-01",
                            "Christopher Allen",
                            "Web Development"),
                    1);
            dbSource.insertOrders("3434bb35f",cart);
        });

        for (int i = 0; i < 1; i++) {
            services.submit(thread);
        }
        services.shutdown();

        ResultSet resultSet = dbSource.getPurchaseHistory("3434bb35f");
        while (resultSet.next()){
            System.out.println(resultSet.getDouble("total"));
        }

    }
}
