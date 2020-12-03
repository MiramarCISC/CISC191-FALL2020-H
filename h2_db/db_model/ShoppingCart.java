package db_model;


import javafx.beans.Observable;
import javafx.beans.value.ObservableMapValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import java.util.function.Consumer;

public class ShoppingCart {
    private List<Book> curCart;
    private LocalDate orderedDate;
    private ObservableList<Book> bookData;


    public ShoppingCart() {
        this.bookData = FXCollections.observableArrayList();
        this.orderedDate = LocalDate.now();
        this.curCart = new ArrayList<>();
    }
    public ObservableList<Book> getBookData(){
        return this.bookData;
    }



    public void addtoCart(Book item){
        this.curCart.add(item);
    }
    public void removefromCart(Book item){
        curCart.remove(item);
    }
//    public void updateCart(Book item, int newQuantity){
//        item.setQuantity(newQuantity);
//    }

    public List<Book> getCurCart() {
        return curCart;
    }


    public LocalDate getOrderedDate()  {
       return orderedDate;
    }
}
