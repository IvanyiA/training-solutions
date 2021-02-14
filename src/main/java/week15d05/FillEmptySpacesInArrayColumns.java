package week15d05;

import java.util.Arrays;

public class FillEmptySpacesInArrayColumns {

    public int[] fillWithZeros(int[] input, int size) {

        int[] result = new int[size];
        System.arraycopy(input, 0, result, 0, input.length);
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3,};

        int[] number5 = new FillEmptySpacesInArrayColumns().fillWithZeros(numbers, 5);
    }

}
