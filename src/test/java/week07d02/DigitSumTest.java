package week07d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitSumTest {

    private int x=123;

    @Test
    public void sumOfDigitsTest(){
        assertEquals(6, DigitSum.sumOfDigits(123));
    }

}