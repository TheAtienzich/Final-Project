import java.util.*;

public class Order {
    private String codeOrder;
    private double totalPrice;
    private Calendar orderDate;
    private Cliente client;
    private HashMap<Candle, String> candlesOrder;


    public Order(String codeOrder, double totalPrice, Calendar orderDate, Cliente client) {
        this.codeOrder = codeOrder;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.client = client;
    }

    public String getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(String codeOrder) {
        this.codeOrder = codeOrder;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClientName(Cliente client) {
        this.client = client;
    }
}
