package week14d03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassNotebook {

    private List<Student> students;

    public ClassNotebook(List<Student> students) {
        this.students = students;
    }

    public void addStudentLater(Student s) {
        students.add(s);
    }

    public List<Student> sortNotebook() {
//        List<Student> result = new ArrayList<>(students);   //visszahat, mert csak a lista referenciáját másolja,
//                                                                  de az elemek referenciája nem változik.
        List<Student> copiedList = new ArrayList<>();
        for (Student s: students){
            copiedList.add(new Student(s));      //így a kopikonstruktorral együtt, teljes másolás következik be a new miatt
        }
        Collections.sort(copiedList);
        return copiedList;
    }

    public List<Student> getStudents() {
        return students;
//        return new ArrayList<>(students);  másolatot hoz létre, így már add metódussal az eredeti nem módosítható, nincs visszahatás
    }

    public static void main(String[] args) {
        ClassNotebook classNotebook = new ClassNotebook(
                new ArrayList<>(List.of(
                        new Student("John"),
                        new Student("Jane"),
                        new Student("Bill"),
                        new Student("Jack"))));

        System.out.println(classNotebook.sortNotebook());
        System.out.println(classNotebook.getStudents());

        classNotebook.getStudents().get(0).addNote("math", 5);
        classNotebook.getStudents().get(0).addNote("math", 2);
        classNotebook.getStudents().get(0).addNote("math", 3);
        classNotebook.getStudents().get(0).addNote("biology", 3);

        System.out.println(classNotebook.getStudents().get(0));

        Student s = new Student("Jackie");
        classNotebook.addStudentLater(s);
        s.addNote("math", 5);

        System.out.println(classNotebook.getStudents().get(4));

        List<Student> result = classNotebook.sortNotebook();
        result.get(0).addNote("math", 4);

        System.out.println(classNotebook.getStudents());//mégis van visszahatás az eredeti listára a sortNotebook által,
        // a sortNotebook módosítása után viszont, már marad az eredeti békében.
    }
}
