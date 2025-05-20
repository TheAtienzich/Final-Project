import java.util.*;
public class ProductManagement {
    static Scanner sc = new Scanner(System.in);
    private List<Candle> candles = new ArrayList<>();

    // Y Tambien se puede implementar ver stock
    public void adminStockMenu(Candle c){
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

            switch (option){
                case 1:
                    System.out.println("Code candle: ");
                    codeCandle = sc.nextLine();
                    if(verifyCandle(codeCandle)){
                        System.out.println("Tell me how many candles you want to add: ");
                        count = sc.nextInt();
                        candle.AnyadirCantidad(count);
                        System.out.println("Candle successfully");
                    } else {
                        System.out.println("Incorrect code candle");
                    }
            }
        } while(option != 0) ;
    }
    public boolean verifyCandle(String codeCandle){
        for(Candle c : candles){
            if(c.getCandleCode().equals(codeCandle)){
                return true;
            }
        }
        return false;
    }
}
