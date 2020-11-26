package week05d2;

import org.junit.jupiter.api.Test;
import week05d02.ChangeLetter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeLetterTest {

    @Test
    void testChangeLetters(){
        assertEquals("*rv*zt*r*", new ChangeLetter().changeVowels("arvizturo"));
    }
}
