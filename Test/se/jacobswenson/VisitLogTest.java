package se.jacobswenson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitLogTest {

   private Customer customer;
   private VisitLog visitLog;


    @BeforeEach
    void setUp() {
        customer = new Customer("Jacob Swenson", "8902060000","2018-12-01");
        visitLog = new VisitLog();
    }

    @Test
    void addToLog() {
        assertTrue(visitLog.addToLog(customer));
    }
}