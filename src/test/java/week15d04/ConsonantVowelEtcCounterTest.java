package week15d04;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class ConsonantVowelEtcCounterTest {

    @Test
    public void testCountAll() {
        InputStream inputStream = ConsonantVowelEtcCounterTest.class.getResourceAsStream("/characters.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        ConsonantVowelEtc cve = new ConsonantVowelEtcCounter().countAll(inputStreamReader);

        assertEquals(6, cve.getConsonant());
        assertEquals(4, cve.getVowel());
        assertEquals(1, cve.getEtc());

    }

}