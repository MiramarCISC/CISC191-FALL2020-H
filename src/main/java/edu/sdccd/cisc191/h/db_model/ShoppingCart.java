/*
 * Contributors: Tu Hoang
 **/
package edu.sdccd.cisc191.h.db_model;

import java.time.LocalDate;
import java.util.*;


/*
 * This class contains a list of items at the check-out session and the corresponding date.
 **/

public class ShoppingCart {
    private List<Book> curCart;
    private LocalDate orderedDate;

    //Constructor
    public ShoppingCart() {

        this.orderedDate = LocalDate.now();
        this.curCart = new ArrayList<>();
    }


    //Setters and getters

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
