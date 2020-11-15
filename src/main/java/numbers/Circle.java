package numbers;

public class Circle {

    private int r2;
    private double pi;

    public Circle(int r2) {
        this.r2 = r2;
        pi = 3.14;
    }

    public double kerületKör() {
        return r2 * pi;
    }

    public double területKör() {
        return (double) r2 * r2 / 4 * pi;
    }
}
