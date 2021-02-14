package week15d01;

import java.util.Map;

public class Graph {

    public Map.Entry<Double, Double> maxValueEntry(Map<Double, Double> graphOfFunction) {
        if (graphOfFunction.size() == 0) {
            throw new IllegalArgumentException("Wrong parameter");
        }
        Map.Entry<Double, Double> result = null;       //egyedi darab
//        double max = -(Double.MAX_VALUE);
        for (Map.Entry<Double, Double> entry : graphOfFunction.entrySet()) {
            if (result == null || result.getValue() < entry.getValue()) {     //rövidzár miatt működik
                result = entry;
//                max = entry.getValue();
            }
        }
        return result;
    }

}
