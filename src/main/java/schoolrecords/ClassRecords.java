package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random rnd = new Random();
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student) {
        for (Student search : students) {
            if (search.getName().equals(student.getName())) {
                return false;
            }
        }
        students.add(student);
        return true;
    }

    public boolean removeStudent(Student student) {
        for (Student searched : students)
            if (searched.getName().equals(student.getName())) {
                students.remove(student);
                return true;
            }
        return false;
    }

    public double calculateClassAverage() {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double classAverage = 0;
        int countStudent = 0;
        for (Student student : students) {
            double studentAverage = student.calculateAverage();
            if (studentAverage != 0) {
                classAverage += studentAverage;
                countStudent++;
            }
            if (countStudent == 0) {
                throw new ArithmeticException("No marks present, average calculation aborted!");
            }
        }
        return Math.round(100 * classAverage / countStudent) / 100.0;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double cLassAverage = 0;
        int countStudent = 0;
        for (Student student : students) {
            double studentAverage = student.calculateSubjectAverage(subject);
            if (studentAverage != 0) {
                cLassAverage += studentAverage;
                countStudent++;
            }
            if (countStudent == 0) {
                throw new ArithmeticException("No marks present, average calculation aborted!");
            }
        }
        return Math.round(100 * cLassAverage / countStudent) / 100.0;
    }

    public Student findStudentByName(String name) {
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to search!");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }


    public Student repetition() {
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(this.rnd.nextInt(students.size()));
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> tempList = new ArrayList<>();
        for (Student student : students) {
            tempList.add(new StudyResultByName(student.calculateAverage(), student.getName()));
        }
        return tempList;
    }

    public String listStudentNames() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.getName()).append(", ");
        }
        return sb.toString().substring(0, sb.lastIndexOf(","));
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}



