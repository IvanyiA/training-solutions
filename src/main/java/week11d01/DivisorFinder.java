package week11d01;

import java.util.ArrayList;

public class DivisorFinder {

    public int findDivisors(int n) {
        ArrayList<Integer> digits = new ArrayList<>();
        do {
            digits.add(n % 10);
            n /= 10;
        } while (n > 0);
        int counter = 0;
        for (int digit : digits) {
            if (digit != 0) {
                int z = n % digit;
                if (z == 0) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public int findDivisors2(int n) {
        n = Math.abs(n);
        int sum = 0;
        String number = Integer.toString(n);
        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt(number.substring(i, i + 1));
            if (digit > 0) {
                int z = n % digit;
                if (z == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }
}

