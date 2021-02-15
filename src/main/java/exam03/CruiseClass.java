package exam03;

public enum CruiseClass {
    LUXURY(3.0), FIRST(1.8), SECOND(1.0);

    private  double multiplicationFactor;

    CruiseClass(double multiplicationFactor) {
        this.multiplicationFactor = multiplicationFactor;
    }

    public double getMultiplicationFactor() {
        return multiplicationFactor;
    }
}
