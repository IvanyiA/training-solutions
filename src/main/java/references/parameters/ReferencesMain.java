package references.parameters;

import java.io.OutputStream;

public class ReferencesMain {

    public static void main(String[] args) {

        Person person = new Person("JD", 47);
        Person otherPerson = person;

        otherPerson.setName("KSZ");

        System.out.println(person.getName() + " " + person.getAge());
        System.out.println(otherPerson.getName() + " " + otherPerson.getAge());

        int i = 24;
        int j = i;
        j = j + 1;

        System.out.println(i + ", " + j);

        otherPerson = new Person("HO", 45);
        System.out.println(person.getName() + " " + person.getAge());
        System.out.println(otherPerson.getName() + " " + otherPerson.getAge());

    }
}
