package se.jacobswenson;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customerOne;
    private Customer customerTwo;

    @BeforeEach
    void setUp() {
        customerOne = new Customer("Jacob Swenson", "8902060000", LocalDate.now().minusMonths(1).toString());
        customerTwo = new Customer("Lasse Kronér", "6312191234", LocalDate.now().minusYears(2).toString());
    }

    /**
     * test av medelmskap giltigt, skall vara true
     */
    @Test
    void membershipIsValid_true() {
        assertTrue(customerOne.membershipIsValid(customerOne));
    }

    /**
     * test av medelmskap giltigt, skall vara false
     */
    @Test
    void membershipIsValid_false() {
        assertFalse(customerTwo.membershipIsValid(customerTwo));
    }
}