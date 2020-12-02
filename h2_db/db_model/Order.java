package db_model;

public class Order {
    private ShoppingCart cart;
    private Customer curCustomer;
    private Double totalPrice;

    public ShoppingCart getCart() {
        return cart;
    }

    public Customer getCurCustomer() {
        return curCustomer;
    }
    public Double getTotalPrice(){
        return cart.getCurCart().stream()
                .map(book -> book.getPrice() * (double) book.getQuantity())
                .reduce(0.0, Double::sum);
    }
}
