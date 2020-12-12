package db_model;

import java.time.LocalDate;
import java.util.*;

public class ShoppingCart {
    private List<Book> curCart;
    private LocalDate orderedDate;

    public ShoppingCart() {

        this.orderedDate = LocalDate.now();
        this.curCart = new ArrayList<>();
    }


    public void addToCart(Book item){
        this.curCart.add(item);
    }

    public List<Book> getCurCart() {
        return curCart;
    }


    public LocalDate getOrderedDate()  {
       return orderedDate;
    }
}
