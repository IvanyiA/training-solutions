package week07d03;

import java.util.List;

public class NumberList {

    public boolean isIncreasing(List<Integer> numbers) {
        boolean result = true;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i-1) > numbers.get(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isIncreasing2(List<Integer> numbers) {
        boolean result = true;
        for (int i = 0; i < numbers.size()-1; i++) {
            if (numbers.get(i) > numbers.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}
