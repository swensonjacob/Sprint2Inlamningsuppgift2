package se.jacobswenson;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Jacob Swenson", "8902060000","2018-12-01");
    }

    @Test
    void membershipIsValid() {
        assertTrue(customer.membershipIsValid(customer));
    }
}