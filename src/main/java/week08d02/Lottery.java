package week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {

    public List<Integer> getNumbers(int interval, int numbers, int seed) {
        List<Integer> result = new ArrayList(numbers);
        for (int i = 0; i < numbers; i++) {
            result.add(generateNumberNotInList(result, interval, seed));
        }
        return result;
    }

    private Integer generateNumberNotInList(List<Integer> mylist, int interval, int seed) {
        Random random = new Random(seed);
        int number = random.nextInt(interval) + 1;
        while (mylist.contains(number)) {
            number = random.nextInt(interval) + 1;
        }
        return number;
    }

    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        System.out.println(lottery.getNumbers(90, 5, 5));
    }

    private List<Integer> getNumbersOneLoop(int interval, int capacity) {
        List<Integer> collection = new ArrayList<>();
        Random random = new Random();

        while (collection.size() < capacity) {
            int number = random.nextInt(interval) + 1;
            if (!collection.contains(number)) {
                collection.add(number);
            }

        }
        return collection;
    }


}
