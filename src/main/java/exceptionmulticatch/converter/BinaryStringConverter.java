package exceptionmulticatch.converter;

public class BinaryStringConverter {


    public boolean[] binaryStringToBooleanArray(String input) {
        if (input == null) {
            throw new NullPointerException("binaryString null");
        }

        boolean[] result = new boolean[input.length()];
        for (int i = 0; i < input.length(); i++) {
            //  char c = input.charAt(i);
            //  boolean[i] = c == '1';
            if (input.charAt(i) == '0') {
                result[i] = false;
            } else if (input.charAt(i) == '1') {
                result[i] = true;
            } else {
                throw new IllegalArgumentException("binaryString not valid");
            }
        }
        return result;
    }

    public String booleanArrayToBinaryString(boolean[] booleans) {
        if (booleans == null) throw new NullPointerException("Boolean input is null");
        if (booleans.length == 0) {
            throw new IllegalArgumentException("Boolean input is empty.");
        }
        StringBuilder sb = new StringBuilder(booleans.length);
        for (boolean item : booleans) {
            sb.append(item ? "1" : "0");
        }
        return sb.toString();
    }

}
