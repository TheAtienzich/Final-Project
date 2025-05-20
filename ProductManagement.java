import java.util.*;
public class ProductManagement {
    static Scanner sc = new Scanner(System.in);
    private List<Candle> candles = new ArrayList<>();

    // Y Tambien se puede implementar ver stock
    public void adminStockMenu(Map<String, Candle> invent){
        int option;
        String codeCandle;
        Candle candle = null;
        int count;

        do {
            System.out.println(" Stock Candles: ");
            System.out.println("0. EXIT  ");
            System.out.println("1. Add candles ");
            System.out.println("2. Substract candles ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option){
                case 1:
                    System.out.println("Code candle: ");
                    // mostrar opcioensde velas
                    codeCandle = sc.nextLine();
                    if(invent.containsKey(codeCandle)){
                        System.out.println("Tell me how many candles you want to add: ");
                        count = sc.nextInt();
                        sc.nextLine();
                        Candle c = invent.get(codeCandle);
                        candle.AnyadirCantidad(count);
                        System.out.println("Candle successfully");
                    } else {
                        System.out.println("Incorrect code candle");
                    }
            }
        } while(option != 0) ;
    }
}
