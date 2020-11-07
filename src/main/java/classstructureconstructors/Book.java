package classstructureconstructors;

public class Book {
    private String author;
    private String title;
    private String regNumber;

    public Book(String szerzo, String cim) {
        this.author = szerzo;
        this.title = cim;
    }

    public void katalogusSzam(String katalogusSzam) {
        this.regNumber = katalogusSzam;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getRegNumber() {
        return regNumber;
    }
}

