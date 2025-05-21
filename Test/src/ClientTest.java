import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    //Test name
    void getName() {
        Client c=new Client("Juan","S","123456789@gmail.com","12345");
        assertNotNull(c.getName());
        assertEquals("Juan", c.getName());
    }

    //Test email
    @Test
    void emailValido()
    {
        assertFalse(Client.emailValido("1234567"));
        assertTrue(Client.emailValido("1234567@gmail.com"));
    }
}