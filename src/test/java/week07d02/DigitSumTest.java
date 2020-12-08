package week07d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitSumTest {

    private int x;

    @Test
    public void sumOfDigitsTest(){
        assertEquals(11, DigitSum.sumOfDigits(623));
    }

}