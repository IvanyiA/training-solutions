package classstructureconstructors;

public class BookMain {
    public static void main(String[] args) {
        Book konyv = new Book("Lewis Carol", "Alice in wonderland");
        konyv.katalogusSzam("1131");
        System.out.println("Szerzo: " + konyv.getAuthor());
        System.out.println("Cím: " + konyv.getTitle());
        System.out.println("Kataloguszám: " + konyv.getRegNumber());
    }
}
