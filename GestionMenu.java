import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private Cliente clienteSesionActual = null;

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

    public void Registrarse(){
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.println();
        System.out.print("Surname: ");
        String surname = sc.nextLine();
        System.out.println();
        System.out.print("Email: ");
        String email = sc.nextLine();
        //Comprobamos que el email incluya @gmail o hotmail o OnFire(correo empresa)
        /*boolean emailValido = Usuario.emailValido(email);
        do{
            System.out.println("Invalid Email");
            System.out.print("Correo: ");
            email = sc.nextLine();
            emailValido = Usuario.emailValido(email);
        }while(!emailValido);*/

        String password = sc.nextLine();
        Cliente c = new Cliente(name, surname, email, password);
        clientsApp.add(c);
        System.out.println("Bienvenido " + c.getName());
        clienteSesionActual = c;
    }

    public void IniciarSesion(){

        System.out.println("Enter email: ");
        String email = sc.nextLine();
        System.out.println("Enter password: ");
        String pass = sc.nextLine();

        try {
            Cliente client = homeSessionCustomer(clientsApp, email , pass);
            System.out.println("Welcome: " + client.getName());
        } catch(Exception e){
            System.out.println("Error");
        }

       /* String email;
        String passWord;
        Cliente c = null;
        boolean emailFound = false, passwordCorrect = false;

        System.out.println("Please enter email");
        email = sc.nextLine();
        if( Usuario.emailValido2(email)==true)
        {
            emailFound=true;
        }

        if(!emailFound) {
            do {
                System.out.println("Email not found in database, try another");
                for (Cliente c1 : clientsApp) {
                    if (c1.getEmail().equals(email)) {
                        c = c1;
                        emailFound = true;
                    }
                }
            /*if(!emailFound){
                System.out.println("Email not found in database, try another");
            }
            } while (!emailFound);
        }

        System.out.println("Please enter password");
        passWord = sc.nextLine();
        do {
            if(passWord.equals(c.getPassWord())) {
                passwordCorrect = true;
            }
            else{
                System.out.println("Incorrect password");
            }
        }while(!passwordCorrect);

        System.out.println("Bienvenido " + c.getName());*/
    }

        /*email = sc.nextLine();do {
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
        clienteSesionActual = c;
    }*/
    /** Function : that receives parameters and returns the result for
     * the test to work properly * */
    public Cliente homeSessionCustomer(List<Cliente> clients,
                                       String email, String pass) throws Exception {
        Cliente customerFind = null;
        for(Cliente c : clients){
            if(c.getEmail().equals(email)){
                if(c.getPassWord().equals(pass)){
                    return c;
                } else {
                    throw new Exception("Incorrect password");
                }
            }
        }
        throw new Exception("Email no found");
    }



    //--------------------------------------------
    public Admin IniciarSesionAdmin() {
        Admin admin = null;
        System.out.println("PIN:" );
        String pin = sc.nextLine();

        for(Admin a : admin) {
            // el admin inicia sesion ocn el pin y contraseña
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
        c.AnyadirCantidad(sc.nextInt());
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
        System.out.println("--------------------------");
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
            System.out.println("-   -   -CARRITO-   -   -");
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

    public void añadirVelas() {
        verCarrito();
        System.out.println("-¿De cual quieres añadir?- (Number)");
        Candle c = Carrito.get(sc.nextInt()-1);
        System.out.println("-¿Cuantas quieres añadir?-");
        c.AnyadirCantidad(sc.nextInt());
    }

    public void quitarVelas() {
        verCarrito();
        System.out.println("-¿De cual quieres quitar?- (Number)");
        Candle c = Carrito.get(sc.nextInt()-1);
        System.out.println("-¿Cuantas quieres quitar?-");
        c.RestarCantidad(sc.nextInt());
    }

    public void confirmarCompra(){
        if(clienteSesionActual.getAddress() == ""){
            System.out.println("Phone Number: ");
            clienteSesionActual.setPhoneNumber(sc.nextInt());
            System.out.println("Postal Code: ");
            clienteSesionActual.setPostalCode(sc.nextLine());
            System.out.println("Province: ");
            clienteSesionActual.setProvince(sc.nextLine());
            System.out.println("Locality: ");
            clienteSesionActual.setLocality(sc.nextLine());
            System.out.println("Address: ");
            clienteSesionActual.setAddress(sc.nextLine());
        }

        System.out.println("---CreditCard Information---");
        String cardNum, CVV, titularName;
        Calendar expirationDate;
        boolean todoCorrecto = true;
        do{
            System.out.println("Credit Card Number: ");
            cardNum = sc.nextLine();
            System.out.println("CVV: ");
            CVV = sc.nextLine();

            if(cardNum.length() != 20 && CVV.length() != 3){
                System.out.println("Invalid Information");
                todoCorrecto = false;
            }
            else{
                todoCorrecto = true;
            }
        } while(!todoCorrecto);


        System.out.println("Titular's name: ");
        titularName = sc.nextLine();

        System.out.println("Expiration Date: ");
        FillDate();
        ConfirmarPedido();
    }

    public double CalculateTotalPrice(){
        double totalPrice = 0;
        for(Candle c : Carrito){
            totalPrice = c.getPrice() * c.getAmount();
        }

        return totalPrice;
    }

    public void ConfirmarPedido(){
        System.out.println("Are you sure of your purchase?(Y/N)");
        boolean letraCorrecta = false;
        do {
            if (sc.nextLine() == "Y") {
                letraCorrecta = true;
                System.out.println("Su pedido le llegara pronto");
                System.out.println("Gracias por su compra!");
                Calendar fechaHoraActual = Calendar.getInstance();
                clienteSesionActual.setNewOrderInList(new Order(CalculateTotalPrice(),
                        fechaHoraActual, clienteSesionActual ));
            } else if (sc.nextLine() == "N") {
                letraCorrecta = true;
                System.out.println("Tomese su tiempo no importa");
                System.out.println("Gracias por confiar en nosotros!");
                menuCarrito();
            } else {
                System.out.println("Intente poner la letra indicada, por favor");
            }
        }while(!letraCorrecta);
    }

    //--------------------------------------------

    //--------------------------------------------

    public void FillDate(){
        LocalDate date;

        try{
            String input = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            date = LocalDate.parse(input, formatter);

        } catch (Exception e) {
            System.out.println("Invalid Date");
            System.out.println();
            FillDate();
        }
    }


    //Search Client
    public static Cliente SearchClient(List<Usuario>usuarios,String email)
    {
        Cliente cliente=null;

        for(Usuario u:usuarios)
        {
            if(u instanceof Cliente) //Check if is type of client
            {
                Cliente c=(Cliente) u;
                if(email.equals(c.getEmail()))
                {
                    cliente=c;
                }
            }
        }
        return  cliente;
    }

    //Search Order
    public static List<Order>searchOrder(List<Order>orders,String email)
    {
        List<Order>orderClient=null;
        for(Order o:orders)
        {
            if(o.getClient().getEmail().equals(email))//Check if the email is same
            {
                orderClient.add(o);
            }
        }
        return orderClient;
    }

    //Search Fragance
    public static Fragance searchFragance(List<Fragance>fragances,String id)
    {
        for(Fragance f:fragances)
        {
            if(f.getID().equals(id))
            {
                return f;
            }
        }
        return null;//if not found
    }

    //Check User
    public static boolean checkUser(List<Usuario>usuarios,String email,String password)
    {
        for(Usuario u :usuarios)
        {
            if(u.getEmail().equals(email))
            {
                if(u.getPassWord().equals(password))
                {
                    return  true;
                }
                else{
                    System.out.println("The password is incorrect");
                    return false;
                }
            }
        }
        System.out.println("Not exist User");
        return false;
    }


}


