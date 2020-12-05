package methodparam.measuring;

public class Measurement {

    private double[] values;

    public Measurement(double[] values) {
        this.values = values;
    }

    public double findFirstIndexInLimit(int lower, int upper) {
        for (int j = 0; j < values.length; j++) {
            if (lower < values[j] && values[j] > upper) {
                return j;
            }
        }
        return -1;
    }

    public double minimum() {
        double min = values[0];
        for (int j = 0; j < values.length; j++) {
            if (values[j] < min) {
                values[j] = min;
            }
        }
        return min;
    }

    public double maximum() {
        double max = values[0];
        for (int j = 0; j < values.length; j++)
            if (values[j] > max) {
                values[j] = max;
            }
        return max;
    }


    public ExtremValues minmax() {
        return new ExtremValues(minimum(), maximum());
    }
}



