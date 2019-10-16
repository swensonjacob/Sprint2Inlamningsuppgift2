package se.jacobswenson;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {
    /**
     * test av att exception throws med felaktigt filnamn.
     */
    @Test
    void setUpRegister_exception() {
        Exception exception = assertThrows(IOException.class, () -> new Register("Wrong.txt"));
        assertEquals("Wrong.txt (No such file or directory)", exception.getMessage());
    }

    /**
     * test av att första kunden i listan efter inläsning av fil inte är null
     */
    @Test
    void setUpRegister_notNull() throws IOException {
        Register register = new Register("temp.txt");
        assertNotNull(register.getCustomers().get(0));
    }

}