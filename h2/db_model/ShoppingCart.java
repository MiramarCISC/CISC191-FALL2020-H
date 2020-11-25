package db_model;


import java.util.HashMap;

import java.util.Map;
import java.util.function.Consumer;

public class ShoppingCart {
    Map<Book, Integer> curCart = new HashMap<>();

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

    public StringBuilder toStringBookList(){
        StringBuilder sb = new StringBuilder();
        curCart.entrySet().forEach(new Consumer<Map.Entry<Book, Integer>>() {
            @Override
            public void accept(Map.Entry<Book, Integer> bookIntegerEntry) {
                sb.append(bookIntegerEntry.getKey().getIsbn()).append("(").append(bookIntegerEntry.getValue()).append(")");
            }
        });
        return sb;

    }
}
