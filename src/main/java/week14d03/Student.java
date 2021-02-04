package week14d03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student implements Comparable<Student> {

    private String studentName;
    private Map<String, List<Integer>> notes = new HashMap<>();

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public Student(Student s) {          //kopikonstruktor
        this.studentName = s.studentName;
        this.notes = new HashMap<>(s.notes); //a new a lényeges
    }

    public String getStudentName() {
        return studentName;
    }

    public Map<String, List<Integer>> getNotes() {
        return notes;
    }

    public void addNote(String subject, int note) {
        if (!notes.containsKey(subject)) {
            notes.put(subject, new ArrayList<>());
        }
        notes.get(subject).add(note);
    }

    @Override
    public int compareTo(Student o) {
        return studentName.compareTo(o.studentName);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", notes=" + notes +
                '}';
    }
}
