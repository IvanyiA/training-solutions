package statements;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;


    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getInMinutes() {
        int hourInMinutes = 60;
        return hours * hourInMinutes + minutes;
    }

    public int getInSeconds() {
        int minutesInSeconds = 60;
        return getInMinutes() * 60 + seconds;
    }

    public boolean earlierThan(Time other) {
        int seconds1 = this.getInSeconds();
        int seconds2 = other.getInSeconds();
        return seconds1 < seconds2;

    }

    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }
}
