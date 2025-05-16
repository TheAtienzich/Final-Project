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
}
