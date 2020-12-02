package H2Database.db_model;

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
        return cart.getCurCart().entrySet().stream()
                .map(book -> book.getKey().getPrice() * Double.valueOf(book.getValue()))
                .reduce(0.0, Double::sum);
    }
}
