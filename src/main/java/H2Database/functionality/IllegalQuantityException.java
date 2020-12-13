package H2Database.functionality;

public class IllegalQuantityException extends Exception {
    public IllegalQuantityException(String insufficient_stock) {
        super(insufficient_stock);
    }
}
