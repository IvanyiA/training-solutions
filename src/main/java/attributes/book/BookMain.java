package attributes.book;

public class BookMain {

    public static void main(String[] args) {
        Book book = new Book("Micimackó");
        System.out.println(book.getTitle());

        book.setTitle("Ördögök");
        System.out.println(book.getTitle());

    }
}
