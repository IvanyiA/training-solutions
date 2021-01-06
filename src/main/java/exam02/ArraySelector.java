package exam02;

public class ArraySelector {

    public String selectEvens(int[] numbers) {
        if (numbers.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < numbers.length; i += 2) {
            sb.append(numbers[i]).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }


}
