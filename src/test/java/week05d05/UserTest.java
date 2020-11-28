package week05d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test

    public void test() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User("John", "Doe", " ");
        });

        assertEquals("John Doe", new User("John", "Doe", "user@domain.com").getFullName());
    }
}