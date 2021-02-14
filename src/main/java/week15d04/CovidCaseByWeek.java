package week15d04;

public class CovidCaseByWeek implements Comparable<CovidCaseByWeek> {

    private String week;
    private int cases;

    public CovidCaseByWeek(String week, int cases) {
        this.week = week;
        this.cases = cases;
    }

    public String getWeek() {
        return week;
    }

    public int getCases() {
        return cases;
    }

    @Override
    public String toString() {
        return "CovidCaseByWeek{" +
                "week='" + week + '\'' +
                ", cases=" + cases +
                '}';
    }

    @Override
    public int compareTo(CovidCaseByWeek o) {
        return o.cases - this.cases;
    }
}
