package week07d02;

public class DigitSum {

    public static int sumOfDigits(int x) {
        int sum = 0;
        while (x > 10) {
            int reminder = x % 10;
            sum = sum + reminder;
            x = x / 10;
        }
        return x + sum;
    }

    public static int sumOfDigitsWithString(int num) {
        int result = 0;
        String digits = String.valueOf(num);
        for (int i = 0; i < digits.length(); i++) {
            result = result + digits.charAt(i);
        }
        return result;
    }


}