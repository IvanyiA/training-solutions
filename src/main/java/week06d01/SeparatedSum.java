package week06d01;

import java.util.ArrayList;
import java.util.List;

public class SeparatedSum {

    public ResultSeparatedSum separatesStringAndSum(String numberString) {
        if (numberString == null || numberString.isBlank()) {
            throw new IllegalArgumentException("Missing data");
        }

        numberString = numberString.replace(",", ".");
        String[] splittedString = numberString.split(";");
        List<Double> positiveNumbers = new ArrayList<>();
        List<Double> negativeNumbers = new ArrayList<>();
        for (String s : splittedString)
            if (s.startsWith("-")) {
                negativeNumbers.add(Double.parseDouble(s));
            } else {
                positiveNumbers.add(Double.parseDouble(s));
            }
        double positiveSum = 0.0;
        for (double d : positiveNumbers) {
            positiveSum += d;
        }

        double negativeSum = 0.0;
        for (double d : negativeNumbers) {
            negativeSum += d;
        }
        return new ResultSeparatedSum(positiveSum, negativeSum);

//        return "A pozitív számok összege: " + Double.toString(positiveSum).substring(0, 5) +
//        ", a negatív számok összege: " + Double.toString(negativeSum).substring(0, 6);
    }
}



