import java.util.*;
public class ProductManagement {
    // añadir velas
    // descontar velas con compra
    private List<Candle> candles = new ArrayList<>();

    public void addCandlesAdmin(Candle c, int count){
        c.AnyadirCantidad(count);
        System.out.println("Stock increased correctly ");
    }

}
