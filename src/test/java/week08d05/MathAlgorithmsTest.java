package week08d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {

    @Test
    public void greatestCommonDivisorTest() {

        MathAlgorithms mathAlgorithms = new MathAlgorithms();

        assertEquals(3, mathAlgorithms.greatestCommonDivisor(6, 9));
        assertEquals(4, mathAlgorithms.greatestCommonDivisor(12, 4));
    }

    @Test
    public void greatestCommonDivisorEuclidean() {

        MathAlgorithms mathAlgorithms = new MathAlgorithms();

        assertEquals(3, mathAlgorithms.greatestCommonDivisorEuclidean(6, 9));
        assertEquals(4, mathAlgorithms.greatestCommonDivisorEuclidean(12, 4));

    }

    @Test
    public void greatestCommonDivisorEuclideanOtherTest() {

        MathAlgorithms mathAlgorithms = new MathAlgorithms();

        assertEquals(3, mathAlgorithms.greatestCommonDivisorEuclideanOther(6, 9));
        assertEquals(4, mathAlgorithms.greatestCommonDivisorEuclideanOther(12, 4));

    }

    @Test
    public void recursiveEuclidean() {

        MathAlgorithms mathAlgorithms = new MathAlgorithms();

        assertEquals(3, mathAlgorithms.recursiveEuclidean(6, 9));
        assertEquals(4, mathAlgorithms.recursiveEuclidean(12, 4));

    }
}