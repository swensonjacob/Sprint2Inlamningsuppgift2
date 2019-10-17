package se.jacobswenson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class VisitLogTest {

    private VisitLog visitLog;


    @BeforeEach
    void setUp() {
        visitLog = new VisitLog();
    }

    /**
     * test av att exception throws med felaktigt filnamn.
     */
    @Test
    void getLogFromFile_exception() {
        Exception exception = assertThrows(IOException.class, () -> visitLog.getLogFromFile("Wrong.txt"));
        assertEquals("Wrong.txt (No such file or directory)", exception.getMessage());
    }
    /**
     * test av att den returnerande Stringen inte är null
     */
    @Test
    void getLogFromFile_notNull() throws IOException {
        assertNotNull(visitLog.getLogFromFile("VisitLog.txt"));
    }
}