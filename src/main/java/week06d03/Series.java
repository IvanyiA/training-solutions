package week06d03;

import java.util.List;

public class Series {

    enum Type {DEC, INC, RANDOM}

    public Type calculateSeriesType(List<Integer> numbers) {
        checkSize(numbers);
        Type type = numbers.get(0) < numbers.get(1) ? Type.INC : Type.DEC;
        for (int i = 2; i < numbers.size(); i++) {
            if (numbers.get(i - 1) < numbers.get(i) && type == Type.DEC ||
                    numbers.get(i - 1) > numbers.get(i) && type == Type.INC) {
                return Type.RANDOM;

            }

        }
        return type;
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers == null || numbers.size() < 2) {
            throw new IllegalArgumentException("Size cannot be lower than 2");
        }
    }

}

//    private boolean isIncreasing(List<Integer> numbers, int index) {
//        return numbers.get(index - 1) > numbers.get(index);
//    }

