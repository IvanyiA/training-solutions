package week15d04;

public class CovidCaseByWeek implements Comparable<CovidCaseByWeek> {

    private String week;
    private int rawCases;

    public CovidCaseByWeek(String week, int rawCases) {
        this.week = week;
        this.rawCases = rawCases;
    }

    public String getWeek() {
        return week;
    }

    public int getRawCases() {
        return rawCases;
    }

    @Override
    public String toString() {
        return "CovidCaseByWeek{" +
                "week='" + week + '\'' +
                ", cases=" + rawCases +
                '}';
    }

    @Override
    public int compareTo(CovidCaseByWeek o) {
        return o.rawCases - this.rawCases;
    }
}
