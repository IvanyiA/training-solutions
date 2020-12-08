package week07d02;

public class DigitSum {

    private int x;

    public static int sumOfDigits(int x) {
        int sum = 0;
        while (x > 10) {
            int reminder = x % 10;
            sum = sum + reminder;
            x = x / 10;
        }
        return x + sum;
    }


}