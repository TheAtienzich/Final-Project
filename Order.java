import java.util.*;

public class Order {
    private String codeOrder;
    private double totalPrice;
    private Calendar orderDate;
    private Cliente client;
    private HashMap<Candle, String> candlesOrder;

    // Aqui quite el codigo de pedido, por que se genera automaticamente
    public Order(double totalPrice, Calendar orderDate, Cliente client) {
        this.codeOrder = GeneradorNumeroPedido.getInstancia().generarNumeroPedido();
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
    // Nuevo metodo implementado para poder mostrar los pedidos
    @Override
    public String toString() {
        String result = codeOrder + ": " +
                "\nTotal price: " + totalPrice +
                "\nOrder date: " + orderDate.getTime() +
                "\nClient: " + client.getName() +
                "\nCandles:\n";

        for (var vela : candlesOrder.entrySet()) {
            result += "   - " + vela.getKey().getName() + " (" + vela.getValue() + ")\n";
        }
        return result;
    }


    public String AFichero() {
        String result = codeOrder + ";" + totalPrice + ";" + orderDate + ";" + client + ";";

        for (var vela : candlesOrder.entrySet()) {
            result += vela.getKey().getName() + "=" + vela.getValue() + ",";
        }
        return result;
    }
}
