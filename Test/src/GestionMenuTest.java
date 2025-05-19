import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GestionMenuTest {
    @Test
    public void homeSessionClientTest() throws Exception {
        Cliente c = new Cliente("Juan",
                "Diaz", "juan.diaz@gmail.com", "12345");

        List<Cliente> clients = List.of(c);
        GestionMenu menu = new GestionMenu();
        Cliente result = menu.homeSessionCustomer(clients,
                "juan.diaz@gmail.com", "12345");
        assertEquals("juan", result.getName());

        /*GestionMenu gestionMenu = new GestionMenu();
        final Cliente result = gestionMenu.IniciarSesion("user@test.com");
        Assertions.assertEquals("","");
        Assertions.assertTrue(true);
        Assertions.assertFalse(false);
        Assertions.fail();
        */
    }
}