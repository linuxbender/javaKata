package ch.theforce;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    @Test
    @DisplayName("Custom test name containing spaces")
    void testWithDisplayNameContainingSpaces() {
        assertEquals(2, 2);
        assertEquals(4, 4, "The optional assertion message is now the last parameter.");
        assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");

        assertAll("person",
                () -> assertEquals("John", "John"),
                () -> assertEquals("Doe", "Doe")
        );
    }

    @Test
    void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });
        assertEquals("a message", exception.getMessage());
    }

    @Test
    void timeoutNotExceeded() {
        // The following assertion succeeds.
        assertTimeout(ofMinutes(2), () -> {
            // Perform task that takes less than 2 minutes.
        });
    }
}
