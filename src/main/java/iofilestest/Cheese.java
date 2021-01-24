package iofilestest;

public class Cheese {

    private final String name;
    private final double lactoseContent;

    public Cheese(String name, double lactoseContent) {
        if (name == null || name.isBlank() || lactoseContent < 0) {
            throw new IllegalArgumentException("Invalid data.");
        }
        this.name = name;
        this.lactoseContent = lactoseContent;
    }

    public String getName() {
        return name;
    }

    public double getLactoseContent() {
        return lactoseContent;
    }
}
