package se.jacobswenson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GymTest {

    private Customer customer;
    private Gym gym;

    @BeforeEach
    void setUp() {
        customer = new Customer("Alhambra Aromes", "7603021234","2018-07-01");
        gym = new Gym();
    }

    @Test
    void customerExists_name() {
        assertNotNull(gym.customerExists(customer.getName()));
    }

    @Test
    void customerExists_personalNumber() {
        assertNotNull(gym.customerExists(customer.getPersonalNumber()));
    }

}