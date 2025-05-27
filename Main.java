import java.util.*;
public class Main {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Admin> admins = new ArrayList<>();
        GestionMenu g = new GestionMenu();
        GestionMenu.opcionMenuBienvenida opcion1;
        GestionMenu.opcionMenuCliente opcionC;
       List<Client>client=new ArrayList<>();
        Admin admin1 = new Admin("Jorge.Reyes@OnFire.com","$1Contraseña1$","Jorge Reyes",
                "PIN01");
        do{
            ///
            opcion1 = g.MenuBienvenida();
            switch(opcion1)
            {
                case REGISTRARSE:
                    g.Registrarse();
                    break;
                case INICIARSESION:
                    g.IniciarSesion();
                    break;
                case SALIR:
                    System.out.println("Thanks for your visit");
                    break;
                default:
                    System.out.println("Choose an option from the menu!!");
            }
        }while(opcion1 != GestionMenu.opcionMenuBienvenida.SALIR);

        do{
            opcionC = g.MenuCliente();
            switch(opcionC)
            {
                case VERCARRITO:
                    g.verCarrito();
                    break;
                case VERPEDIDOS:
                    g.verPedido((Client) client);
                    break;
                case VERVELAS:
                    g.verListadoVelas();
                    break;
                case SALIR:
                    System.out.println("Thanks for your visit");
                    break;
                default:
                    System.out.println("Choose an option from the menu!!");
            }
        }while(opcionC != GestionMenu.opcionMenuCliente.SALIR);
    }
}