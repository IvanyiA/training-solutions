package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    public double calculateAverage() {
        if (marks.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Mark mark : marks) {
            sum += mark.getMarkType().getValue();
        }
        double average;
        average = sum / marks.size();
        return Math.round(average * 100) / 100.0;
    }

    public double calculateSubjectAverage(Subject subject) {
        if (marks.isEmpty()) {
            return 0;
        }
        double sum = 0;
        int count = 0;
        for (Mark mark : marks) {
            if (mark.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                sum += mark.getMarkType().getValue();
                count++;
            }
        }
        if (sum == 0) {
            return 0;
        }
        double average = sum / count;
        return Math.round(average * 100) / 100.0;
    }

    public String getName() {
        return name;
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    @Override
    public String toString() {
        String temp = name + " marks: ";
        for (Mark mark : marks) {
            temp += mark.getSubject().getSubjectName() + ": " + mark.toString();
        }
        return temp;
    }
}
