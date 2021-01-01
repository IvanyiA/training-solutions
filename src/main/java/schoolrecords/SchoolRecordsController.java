package schoolrecords;

import java.util.*;

public class SchoolRecordsController {

    private ClassRecords classRecords = new ClassRecords("2.m", new Random());
    private List<Subject> subjects;
    private List<Tutor> tutors;

    Scanner scanner = new Scanner(System.in);

    public void initSchools() {
        Subject literature = new Subject("literature");
        Subject biology = new Subject("biology");
        Subject physics = new Subject("physics");
        subjects = new ArrayList<>(Arrays.asList(literature, biology, physics));

        tutors = new ArrayList<>(Arrays.asList(new Tutor("JD", new ArrayList<>(Arrays.asList(biology, physics)))));
    }

    public void menuToConsole() {
        System.out.println(
                "    1. Diákok nevének listázása\n" +
                        "    2. Diák név alapján keresése\n" +
                        "    3. Diák létrehozása\n" +
                        "    4. Diák név alapján törlése\n" +
                        "    5. Diák feleltetése\n" +
                        "    6. Osztályátlag kiszámolása\n" +
                        "    7. Tantárgyi átlag kiszámolása\n" +
                        "    8. Diákok átlagának megjelenítése\n" +
                        "    9. Diák átlagának kiírása\n" +
                        "   10. Diák tantárgyhoz tartozó átlagának kiírása\n" +
                        "   11. Kilépés");
    }

    private Tutor findTutorByName(String tutorName) {
        for (Tutor tutor : tutors) {
            if (tutorName.equals(tutor.getName())) {
                return tutor;
            }
        }
        throw new IllegalArgumentException("Can't find tutor with this name.");
    }

    private Subject findSubjectByName(String subjectName) {
        for (Subject subject : subjects) {
            if (subjectName.equals(subject.getSubjectName())) {
                return subject;
            }
        }
        throw new IllegalArgumentException("Can't find subject with this name.");
    }

    private MarkType findMarkTypeByValue(int value) {
        for (MarkType markType : MarkType.values()) {
            if (markType.getValue() == value) {
                return markType;
            }
        }
        throw new IllegalArgumentException("Cannot find mark with this value.");
    }

    public String oneDataIn() {
        System.out.println("Kérem az adatot: ");
        return scanner.nextLine();
    }

    public void averageOfOneStudent() {
        Student student = classRecords.findStudentByName(oneDataIn());
        System.out.println(student.calculateAverage());
    }

    public void getAverageOfStudentBySubject() {
        Student student = classRecords.findStudentByName(oneDataIn());
        Subject subject = findSubjectByName(oneDataIn());
        System.out.println(student.calculateSubjectAverage(subject));
    }

    public void studentRepetition() {
        Student student = classRecords.repetition();
        System.out.println("Kérem a jegyet: ");
        int mark = Integer.parseInt(scanner.nextLine());
        System.out.println("Kérem a tárgy nevét: ");
        String subjectName = scanner.nextLine();
        System.out.println("Kérem a tanár nevét: ");
        String tutorName = scanner.nextLine();

        Mark actualMark = new Mark(findMarkTypeByValue(mark), findSubjectByName(subjectName), findTutorByName(tutorName));
        student.grading(actualMark);
    }

    public void executeMenu(int menuNumber) {
        switch (menuNumber) {
            case 1: {
                System.out.println(classRecords.listStudentNames());
                return;
            }
            case 2: {
                System.out.println(classRecords.findStudentByName(oneDataIn()));
                return;
            }
            case 3: {
                classRecords.addStudent(new Student(oneDataIn()));
                return;
            }
            case 4: {
                classRecords.removeStudent(new Student(oneDataIn()));
                return;
            }
            case 5: {
                studentRepetition();
                return;
            }
            case 6: {
                classRecords.calculateClassAverage();
                return;
            }
            case 7: {
                System.out.println(classRecords.calculateClassAverageBySubject(new Subject(oneDataIn())));
                return;
            }
            case 8: {
                System.out.println(classRecords.listStudyResults());
                return;
            }
            case 9: {
                averageOfOneStudent();
                return;
            }
            case 10: {
                getAverageOfStudentBySubject();
                return;
            }
            case 11: {
                return;
            }
            default: {
                System.out.println("Nincs ilyen menüpont.");
            }
        }
    }

    public void runMenu() {
        int menuNumber = 0;
        while (menuNumber != 11) {
            menuToConsole();
            System.out.println("Kérem adja meg a választott menü számát: ");
            menuNumber = 2;
            menuNumber = Integer.parseInt(scanner.nextLine());
            executeMenu(menuNumber);
        }
    }

    public static void main(String[] args) {
        SchoolRecordsController schoolRecordsController = new SchoolRecordsController();
        schoolRecordsController.initSchools();
        schoolRecordsController.runMenu();
    }
}

