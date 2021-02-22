package exam03retake01;

public class CdvCheck {

    public boolean check(String stringNumber) throws IllegalArgumentException {
        if (stringNumber.length() != 10) {
            throw new IllegalArgumentException("Invalid number length");
        }
        char[] charsNumbers = stringNumber.toCharArray();
        int temp = 0;
        for (int i = 1; i < 10; i++) {
            temp += i * (Character.getNumericValue(charsNumbers[i - 1]));
        }
        int residual = temp % 11;
        return residual == Character.getNumericValue(charsNumbers[9]);
    }


}

