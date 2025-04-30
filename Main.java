import java.util.*;
public class Main {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        GestionMenu g = new GestionMenu();
        GestionMenu.opcionMenuBienvenida opcion1;
        GestionMenu.opcionMenuCliente opcionC;
        Cliente c = null;
        do{
            opcion1 = g.MenuBienvenida();
            switch(opcion1)
            {
                case REGISTRARSE:
                    c = g.Registrarse();
                    break;
                case INICIARSESION:
                    c = g.IniciarSesion();
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
                    break;
                case VERPEDIDOS:
                    break;
                case VERVELAS:
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