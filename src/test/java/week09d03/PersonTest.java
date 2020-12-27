package week09d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void testOverForteen() {
        Person person = new Person("John Doe", 15);
        person.setPresent();
        assertNotEquals(null, person.getPresent() );
        assertNotEquals(Present.TOY, person.getPresent() );

    }

}