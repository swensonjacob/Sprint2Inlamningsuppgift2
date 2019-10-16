package se.jacobswenson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GymTest {

    private Customer customerOne;
    private Customer customerTwo;
    private Gym gym;

    @BeforeEach
    void setUp() {
        customerOne = new Customer("Alhambra Aromes", "7603021234", "2018-07-01");
        customerTwo = new Customer("Jacob Swenson", "8902060000", "2007-05-11");
        gym = new Gym();
    }

    /**
     * test av medlemskap giltigt, skall vara true
     */
    @Test
    void customerExists_name_notNull() {
        String customerName = gym.customerExists(customerOne.getName()).getName();
        assertEquals(customerOne.getName(), customerName);
    }

    /**
     * test av medlemskap giltigt, skall vara false
     */
    @Test
    void customerExists_name_null() {
        assertNull(gym.customerExists(customerTwo.getName()));
    }

    /**
     test av CustomerOne återfinns som kund, skall finnas
     */
    @Test
    void customerExists_personalNumber_notNull() {
        String personalNumber = gym.customerExists(customerOne.getName()).getPersonalNumber();
        assertEquals(customerOne.getPersonalNumber(), personalNumber);
    }

    /**
     * test av CustomerOne återfinns som kund, skall inte hittas
     */
    @Test
    void customerExists_personalNumber_null() {
        assertNull(gym.customerExists(customerTwo.getPersonalNumber()));
    }

}