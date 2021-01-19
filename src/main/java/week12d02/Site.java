package week12d02;

public class Site {

    private int evenOdd;
    private int plotLength;
    private Fence fence;

    public Site(int evenOdd, int plotLength, Fence fence) {
        this.evenOdd = evenOdd;
        this.plotLength = plotLength;
        this.fence = fence;
    }

    public int getEvenOdd() {
        return evenOdd;
    }

    public int getPlotLength() {
        return plotLength;
    }

    public Fence getFence() {
        return fence;
    }
}
