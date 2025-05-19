import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestionMenuTest {
    @Test
    public void test1()
    {
        GestionMenu gestionMenu = new GestionMenu();
        final Cliente result = gestionMenu.IniciarSesion("salet.arlet@gmail.com", "");
        Assertions.assertEquals("","");
        Assertions.assertTrue(true);
        Assertions.assertFalse(false);
        Assertions.fail();

    }
}