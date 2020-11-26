package db_model;


import java.util.Date;
import java.util.HashMap;

import java.util.Map;
import java.util.function.Consumer;

public class ShoppingCart {
    Map<Book, Integer> curCart = new HashMap<>();
    Date orderedDate;

    private final int INITIAL_QUANTITY = 1;

    public void addtoCart(Book item){
        curCart.put(item,INITIAL_QUANTITY);
    }
    public void removefromCart(Book item){
        curCart.remove(item);
    }
    public void updateCart(Book item, int newQuantity){
        curCart.put(item,newQuantity);
    }

    public Map<Book, Integer> getCurCart() {
        return curCart;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }
}
