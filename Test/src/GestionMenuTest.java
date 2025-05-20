import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GestionMenuTest {
    @Test
    public void homeSessionClientTest() throws Exception {
        Client c = new Client("Juan",
                "Diaz", "juan.diaz@gmail.com", "12345");

     //   List<Client> clients = List.of(c);
      //  Client client = Client.homeSessionCustomer(clients, "jorgeReyes@gmail.com", "Contraseña$");
    }
    // registro test
    @Test
    public void homeSessionAdminTest() throws Exception {
        //Admin a = new Admin("juanReyes@OnFire.com", "1234","00000F");
    }

}