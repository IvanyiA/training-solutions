package exam02;

import java.util.Arrays;

public class ArraySelector {

    public String selectEvens(int[] numbers) {
        if (numbers.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder("[");
//        boolean first = true;
        for (int i = 0; i < numbers.length; i += 2) {
            sb.append(numbers[i]).append(", ");

//            if (!first) {
//                sb.append(", ");
//            } else (first = false);
//            sb.append(i);

//            if (i != 0){
//                sb.append(", ");
//            }
//            sb.append(i);
//
//            if (i != numbers.length - 1){
//                sb.append(", ");
//            }
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public String selectEvens2(int[] ints) {
        if (ints.length == 0) {
            return "";
        }

        int[] result = new int[(int) Math.round(ints.length / 2.0)];
        for (int i = 0; i < ints.length; i = i + 2) {
            result[i / 2] = ints[i];
        }
        return Arrays.toString(result);
    }

}
