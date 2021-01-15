package ioreadstring.names;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    private final Human human = new Human("John", "Doe");

    @Test
    public void createHumanTest(){
        assertEquals("John", human.getFirstName());
        assertEquals("Doe", human.getLastName());
    }

}