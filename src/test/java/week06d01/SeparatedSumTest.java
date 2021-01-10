package week06d01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedSumTest {

    private String numberString;

    @BeforeEach
    void setUp() {
        numberString = "2,0;3,0;-4,0;-5,0";
    }

    @Test
    public void separatesStringAndSum () {

        assertEquals(5, new SeparatedSum().separatesStringAndSum(numberString).getPositiveSum() );
        assertEquals(-9, new SeparatedSum().separatesStringAndSum(numberString).getNegativeSum() );

    }
}