package collectionsiterator;

public class Book {

    public int regNumber;
    public String title;
    public String author;

    public Book(int regNumber, String title, String author) {
        this(title,author);
        this.regNumber = regNumber;
           }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
