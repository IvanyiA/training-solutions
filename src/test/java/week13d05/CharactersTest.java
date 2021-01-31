package week13d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharactersTest {

    @Test
    public void uniqueCharacterCounterTest() {
        Characters characters = new Characters();

        assertEquals(4, characters.uniqueCharacterCounter("Ágnes"));
        assertEquals(3, characters.uniqueCharacterCounter("Alma  "));

    }

}