package db_main;

import db_model.ShoppingCart;

public class updateStockCaller{
    private ShoppingCart cart;

//    public updateStockCaller(ShoppingCart cart) {
//        this.cart = cart;
//    }
//
//    @Override
//    public void run() {
//        Statement stm = null;
//
//        Map<Book, Integer> tempCart = cart.getCurCart();
//        Iterator<Map.Entry<Book, Integer>> iterator = tempCart.entrySet().iterator();
//        String sql = "UPDATE " + DBSource.BOOKS_TABLE + " SET stock = stock - 1 WHERE isbn = ";
//        try {
//            stm = DBSource.getConnection().createStatement();
//
//            while (iterator.hasNext()) {
//                stm.executeUpdate(sql + iterator.next().getKey().getIsbn());
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Something went wrong when updating stock.." + e.getMessage());
//        } finally {
//            try {
//                if (stm != null) {
//                    stm.close();
//                }
//            } catch (SQLException e) {
//                System.out.println("Error when closing Statement.. " + e.getMessage());
//            }
//        }
//    }
}