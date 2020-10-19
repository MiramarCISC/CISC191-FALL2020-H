package com.company;

import java.util.ArrayList;
import java.util.List;

public class BookListCheckout {
    private List<Book> checkoutList = new ArrayList<>();
    private int bookItems;
    public void addbookItem(Book item){
        checkoutList.add(item);
    }

}
