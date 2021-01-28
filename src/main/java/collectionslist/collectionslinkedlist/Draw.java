package collectionslist.collectionslinkedlist;

import java.util.*;

public class Draw {

    public Set<Integer> drawNumbers(int drawCount, int maxNumber) throws IllegalArgumentException {
        if (maxNumber <= drawCount) {
            throw new IllegalArgumentException("drawCount must be less then " + maxNumber + "!");
        }

        List<Integer> numbers = createNumbersPool(maxNumber);

        Set<Integer> winningNumbers = new TreeSet<>();
        for (int i = 0; i < drawCount; i++) {
            winningNumbers.add(numbers.get(i));
        }
        return winningNumbers;
    }

    private List<Integer> createNumbersPool(int maxNumber) {
        List<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= maxNumber; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

}
