package week09d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibCalculatorTest {

    @Test
    public void testsumEvens() {
        assertEquals(0, FibCalculator.sumEvens(0) );
        assertEquals(2, FibCalculator.sumEvens(3) );
        assertEquals(2, FibCalculator.sumEvens(4) );
        assertEquals(10, FibCalculator.sumEvens(9) );
    }

}