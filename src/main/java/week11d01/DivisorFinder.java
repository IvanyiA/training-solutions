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
//            int digit = Integer.parseInt(Character.toString(number.charAt(i)));
            if (digit > 0) {
                int z = n % digit;
                if (z == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public int findDivisors3(int n) {
        int counter = 0;
        int number = Math.abs(n);
        while (number > 0) {
            if ((number % 10 != 0) && (n % (number % 10) == 0)) {
                counter++;
            }
            number /= 10;
        }
        return counter;
    }

}

