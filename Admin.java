import java.io.*;
import java.util.*;

public class Admin extends Usuario {
    private String claveEmpresa;
    public static final String FILENAME = "admin.txt";
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
    public static void showClients(List<Cliente>clientes)
    {
        System.out.println("List of clients: ");
        for(Cliente c : clientes)
        {
            System.out.println(c);
            System.out.println("------------");
        }
    }
    public static void showOrders(List<Cliente> clientes)
    {
        for(Cliente c : clientes)
        {
            System.out.println("Client: " + c.getName());
            System.out.println("Email: " + c.getEmail());
            System.out.println("Pedidos: ");
            for (Order o: c.getOrdersClient())
            {
                System.out.println(o);
            }
            System.out.println("==========");
        }
    }

    public static void showCandle(List<Candle>candles)
    {
        for(Candle c:candles)
        {
            System.out.println("Name:"+c.getName()+"("+c.getCandleCode()+")");
            System.out.println("shortDescp:"+c.getShortDescp());
            System.out.println("CandleFragrance:"+c.getCandleFragrance());
            System.out.println("Price:"+c.getPrice());
        }
    }

    //LoadAdmin
    public static List<Admin>LoadAdmin()
    {
        List<Admin>admins=new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parts = linea.split(";");
                if (parts.length >= 4) {
                    String email = parts[0];
                    String contrasenya = parts[1];
                    String nombre = parts[2];
                    String claveEmpresa = parts[3];

                    Admin admin = new Admin(email, contrasenya, nombre);

                    admins.add(admin);
                }
            }
        }
        catch(IOException e)
        {
            System.err.println("Error:"+e.getMessage());
        }
        return admins;
    }

    //Save Admin
    public static void saveAdmin(List<Admin>admins)throws IOException
    {
        BufferedWriter writer=new BufferedWriter(new FileWriter(FILENAME));

        for(Admin a:admins)
        {
            writer.write(a.AFichero());
            writer.newLine();
        }
        writer.close();
    }


}
