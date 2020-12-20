package week08d05;

import java.util.ArrayList;
import java.util.List;

public class MathAlgorithms {

    public int greatestCommonDivisor(int first, int second) {

        int maxDivisor = 1;

        for (int possibleDivisor = 1; possibleDivisor <= Math.min(first, second); possibleDivisor++) {
            if (first % possibleDivisor == 0 && second % possibleDivisor == 0) {

                maxDivisor = possibleDivisor;
            }
        }
        return maxDivisor;
    }

    public int greatestCommonDivisorEuclidean(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int greatestCommonDivisorEuclideanOther(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public int recursiveEuclidean(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return recursiveEuclidean(b, a % b);
        }
    }

}
