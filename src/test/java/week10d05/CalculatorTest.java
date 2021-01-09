package week10d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void findMinSum() {

        assertEquals(16, new Calculator().findMinSum(new int[]{1, 3, 5, 7, 9}));
    }

    @Test
    void invalidListSize() {

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Calculator().findMinSum(new int[]{1, 3, 5}));

        assertEquals("A listának legalább 4 eleműnek kell lennie", exception.getMessage());


    }

}