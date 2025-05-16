import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class GestionMenu {
    Scanner sc = new Scanner(System.in);
    private final List<Candle> stockCandles =  new ArrayList<>();
    private final Fragance[] stockFragances = new Fragance[100];
    //En cada posicion de esa lista se va a guardar un objeto vela (Se usara en la primera opcion de "Mostrar velas")
    private final List<Cliente> clientsApp = new ArrayList<>();
    private final List<Candle> Carrito =  new ArrayList();

    enum opcionMenuBienvenida { SALIR, INICIARSESION, REGISTRARSE }
    enum opcionMenuCliente { SALIR, VERCARRITO, VERPEDIDOS, VERVELAS }
    enum opcionMenuAdmin {}
    enum opcionMenuCarrito { SALIRCARRITO, AÑADIRVELAS, QUITARVELAS, CONFIRMARCOMPRA }
    enum opcionMenuVelasDetallado { SALIRMENU, AÑADIRVELASCARRITO }

    public Fragance[] getFragances() {
        stockFragances[0] = new Fragance("Lavanda", "0001LA",
                "Fresco olor a lavanda, hecho 100% de la flor");
        stockFragances[1] = new Fragance("Chocolate", "0002CH",
                "Dulce olor al chocolate con leche");
        stockFragances[2] = new Fragance("Brisa Campesina", "0003BR",
                "Fresco olor al campo alicantino, 0% polucion");
        stockFragances[3] = new Fragance("Vainilla", "0004VA",
                "Fresco y dulce olor a Vainilla, igualito al helado");
        stockFragances[4] = new Fragance("Eucalipto", "0005EU",
                "Fresco olor a lavanda, hecho 100% de la flor");
        return stockFragances;
    }

    public List<Candle> RellenarVelas(){
        Fragance[] fragances = getFragances();
        stockCandles.add(new Candle("Brisa en el Campo",
                "La brisa de olor que te deja esta vela se puede relacionar\n" +
                "a aquel sentimiento que sentias al salir al campo despues\n" +
                "de dormir en casa de tu abuela en la cañada y respirar ese \n" +
                "aire nocturno sin polución, simplemente epico.",
                "Como no olvidar ese olor a campo por la noche",
                fragances[2], 8.50, "0101BR"));
        stockCandles.add(new Candle("Cacao Intenso",
                "Cacao Intenso está hecha para los amantes del chocolate.\n" +
                        "Su fragancia rica y cremosa evoca una taza de chocolate caliente, \n" +
                        "con notas de cacao amargo, azúcar morena y un toque de vainilla.\n" +
                        "Ideal para ambientes acogedores y momentos dulces",
                "Vela cálida y reconfortante con aroma de chocolate oscuro.",
                fragances[1], 8.50, "0102CH"));
        stockCandles.add(new Candle("Eucalipto Fresco",
                "Diseñada para despejar la mente y el ambiente, “Eucalipto Fresco”\n" +
                        "combina eucalipto natural con un ligero toque de menta y romero.\n" +
                        "Esta vela purifica el aire, estimula la respiración y es ideal para\n" +
                        "baños o espacios de meditación.",
                "Aroma refrescante con eucalipto puro y menta.",
                fragances[4], 8.50, "0103EU"));
        stockCandles.add(new Candle("Esencia de Vainilla",
                "Suave y envolvente, esta vela ofrece una experiencia olfativa cálida\n" +
                        "y familiar. La vainilla pura se mezcla con notas de crema y caramelo,\n" +
                        "creando una atmósfera relajante y hogareña. Perfecta para salas, dormitorios\n" +
                        "o como fondo neutro y elegante.",
                "Aroma clásico y dulce con vainilla natural.",
                fragances[3], 8.50, "0104VA"));
        stockCandles.add(new Candle("Lavanda Silvestre",
                "Inspirada en campos de lavanda al atardecer, esta vela aporta calma\n" +
                        "y equilibrio. Las notas florales de lavanda se fusionan con un\n" +
                        "fondo suave de salvia y musgo, creando una atmósfera ideal para\n" +
                        "descansar o antes de dormir.",
                "Fragancia relajante de lavanda con notas herbales.",
                fragances[0], 8.50, "0102CH"));
        return stockCandles;
    }

    //MenuBienvenida
    public opcionMenuBienvenida MenuBienvenida(){
        int seleccion;
        boolean norepetir = false;
        do {
            System.out.println("---BIENVENIDO A ONFIRE---");
            System.out.println(" 1. Iniciar Sesion");
            System.out.println(" 2. Registrarse");
            System.out.println(" 0. Salir");
            System.out.println("-------------------------");
            System.out.println("---¿Que quieres hacer?---");
            seleccion = sc.nextInt();
            if(seleccion == 1 || seleccion == 2 || seleccion == 0){
                norepetir = true;
            }
        }while(!norepetir);
        return opcionMenuBienvenida.values()[seleccion];
    }

    public Cliente Registrarse(){
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.println();
        System.out.print("Surname: ");
        String surname = sc.nextLine();
        System.out.println();
        System.out.print("Email: ");
        String email = sc.nextLine();
        //Comprobamos que el email incluya @gmail o hotmail o OnFire(correo empresa)
        boolean emailValido = Usuario.emailValido(email);
        do{
            System.out.println("Invalid Email");
            System.out.print("Correo: ");
            email = sc.nextLine();
            emailValido = Usuario.emailValido(email);
        }while(!emailValido);
        String password = sc.nextLine();
        Cliente c = new Cliente(name, surname, email, password);
        clientsApp.add(c);
        System.out.println("Bienvenido " + c.getName());
        return c;
    }

    public Cliente IniciarSesion(){
        String email;
        String passWord;
        Cliente c = null;
        boolean emailFound = false, passwordCorrect = false;
        email = sc.nextLine();
        do {
            for (Cliente c1 : clientsApp) {
                if (c1.getEmail().equals(email)) {
                    c = c1;
                    emailFound = true;
                }
            }
            if(!emailFound){
                System.out.println("Email not found in database, try another");
            }
        }while(!emailFound);
        passWord = sc.nextLine();
        do {
            if(passWord.equals(c.getPassWord())) {
                passwordCorrect = true;
            }
            else{
                System.out.println("Incorrect password");
            }
        }while(!passwordCorrect);

        System.out.println("Bienvenido " + c.getName());
        return c;
    }
    //--------------------------------------------
    public Admin IniciarSesionAdmin()
    {
        Admin admin = null;
        System.out.println("PIN:" );
        String pin = sc.nextLine();

        for(Admin a : admin)
        {

        }

    }

    //Opcion ver velas
    public opcionMenuVelasDetallado MenuVelasDetallada(Candle c) {
        int seleccion;
        boolean norepetir = false;
        do {
            System.out.println("-   -¿QUE QUIERES HACER?-   -");
            System.out.println(" 1. Añadir la vela al carrito");
            System.out.println(" 0. Salir al menu");
            System.out.println("-------------------------");
            seleccion = sc.nextInt();
            if (seleccion == 1 || seleccion == 0) {
                norepetir = true;
            }
        } while (!norepetir);
        return opcionMenuVelasDetallado.values()[seleccion];
    }

    public void AñadirVelaCarrito(Candle c){
        System.out.println("¿Cuantas de estas velas quieres?");
        c.AñadirCantidad(sc.nextInt());
        Carrito.add(c);
    }

    public void SalirAMenuVelas(){
        verListadoVelas();
    }

    public void verVelaPagina(int seleccion){
        Candle v = stockCandles.get(seleccion);
        System.out.println("Nombre: " + v.getName());
        System.out.println(v.getLongDescrp());
        System.out.println("Precio: " + v.getPrice());
        MenuVelasDetallada(v);
    }

    public void verListadoVelas(){
        System.out.println("- - -VELAS AROMATICAS- - -");
        for (int i = 0; i < stockCandles.size(); i++) {
            Candle v = stockCandles.get(i);
            System.out.println((i + 1) + ". " + v.getName() + " "
                    + v.getShortDescp());
        }
        System.out.println("--------------------------");
        System.out.println("--¿Que vela quieres ver?--");
        int seleccion = sc.nextInt()-1;
        verVelaPagina(seleccion);
    }
    //--------------

    //Menu Cliente
    public opcionMenuCliente MenuCliente(){
        int seleccion;
        boolean norepetir = false;
        do {
            System.out.println("-   -   -ONFIRE!-   -   -");
            System.out.println(" 1. Ver el carrito");
            System.out.println(" 2. Ver mis pedidos");
            System.out.println(" 3. Ver el listado de velas");
            System.out.println(" 0. Salir");
            System.out.println("-------------------------");
            System.out.println("---¿Que quieres hacer?---");
            seleccion = sc.nextInt();
            if(seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 0){
                norepetir = true;
            }
        }while(!norepetir);
        return opcionMenuCliente.values()[seleccion];
    }
    //----------------------------------

    //Opcion VerCarrito
    public void verCarrito(){
        System.out.println("-   -   -CARRITO-   -   -");
        int contador = 1;
        for(Candle c : Carrito){
            System.out.println(contador + ". " +
                    c.getName() + "; " + c.getShortDescp() + "; "
                    + c.getAmount());
            contador++;
        }
        System.out.println("-------------------------");
    }
    public void verPedido(Cliente cliente)
    {
        List<Order> orders = cliente.getOrdersClient();
        if(orders.isEmpty()){ // si no hay pedidos
            System.out.println("You not have orders");
        } else {
            System.out.println(" Your orders: ");
            for(Order order: orders){
                order.toString();
            }
        }
    }
    public opcionMenuCarrito menuCarrito(){
        int seleccion;
        boolean norepetir = false;
        do {
            verCarrito();
            System.out.println("---¿Que quieres hacer?---");
            System.out.println("1. " + opcionMenuCarrito.AÑADIRVELAS);
            System.out.println("2. " + opcionMenuCarrito.QUITARVELAS);
            System.out.println("3. " + opcionMenuCarrito.CONFIRMARCOMPRA);
            System.out.println("0. " + opcionMenuCarrito.SALIRCARRITO);
            System.out.println("-------------------------");
            seleccion = sc.nextInt();
            if(seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 0){
                norepetir = true;
            }
        } while(!norepetir);
        return opcionMenuCarrito.values()[seleccion];
    }
}
