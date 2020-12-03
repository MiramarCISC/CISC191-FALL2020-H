package FX.fx_model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PurchaseHistory {
    private final StringProperty orderID;
    private final StringProperty date;
    private final DoubleProperty total;

    public PurchaseHistory(String orderID, String date, Double total) {
        this.orderID = new SimpleStringProperty(orderID);
        this.date = new SimpleStringProperty(date);
        this.total = new SimpleDoubleProperty(total);
    }

    public String getOrderID() {
        return orderID.get();
    }

    public StringProperty orderIDProperty() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID.set(orderID);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public double getTotal() {
        return total.get();
    }

    public DoubleProperty totalProperty() {
        return total;
    }

    public void setTotal(double total) {
        this.total.set(total);
    }
}
