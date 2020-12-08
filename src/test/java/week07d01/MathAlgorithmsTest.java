package week07d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {

    @Test
    public void testPrime(){
        assertTrue(new MathAlgorithms().isPrime(7));
    }


    @Test
    public void testPrimeMinus() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new MathAlgorithms().isPrime(-1);
        });
        assertEquals("Ez nem pozitív szám.", ex.getMessage());
    }


}