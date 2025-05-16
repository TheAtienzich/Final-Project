import java.util.*;

public class Admin extends Usuario {
    private String claveEmpresa;

    public Admin(String email, String contrasenya, String nombre){
        super(email, contrasenya, nombre);
        this.claveEmpresa = "000000F";
    }

    @Override
    public String AFichero(){
        return super.AFichero() + ";" +  claveEmpresa;
    }

    @Override
    public String ToString(){
        return super.ToString() + " Clave Empresa: " + claveEmpresa;
    }

    //View Candle
    public static void viewCandle(List<Candle>candles)
    {
        for(Candle c: candles)
        {
            System.out.println("Name:"+c.getName()+"("+c.getCandleCode()+")");
            System.out.println("Description:"+c.getShortDescp());
            System.out.println("Candle Fragrance:"+c.getCandleFragrance());
            System.out.println("Price"+c.getPrice());
        }
    }
}
