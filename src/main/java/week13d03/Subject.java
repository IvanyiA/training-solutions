package week13d03;

public class Subject {

    private String teacherName;
    private String subject;
    private String className;
    private int taughtHoursNumber;

    public Subject(String teacherName, String subject, String className, int taughtHoursNumber) {
        this.teacherName = teacherName;
        this.subject = subject;
        this.className = className;
        this.taughtHoursNumber = taughtHoursNumber;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getSubject() {
        return subject;
    }

    public String getClassName() {
        return className;
    }

    public int getTaughtHoursNumber() {
        return taughtHoursNumber;
    }
}
