package week09d03;

import java.util.List;

public class SantaClaus {

    List<Person> people;


    public SantaClaus(List<Person> people) {
        this.people = people;
    }

    public void getThroughChimneys(List<Person> people) {
        for (Person person : people) {
            person.setPresent();
        }
    }
}
