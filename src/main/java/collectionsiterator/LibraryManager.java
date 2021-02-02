package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {

    private Set<Book> booksCatalogSet = new HashSet<>();


    public LibraryManager(Set<Book> booksCatalogSet) {
        this.booksCatalogSet = booksCatalogSet;
    }

    public Book findBookByRegNumber(int regNumber) {
        Book book;
        Iterator<Book> booksIter = booksCatalogSet.iterator();

        while (booksIter.hasNext()) {
            book = booksIter.next();
            if (book.getRegNumber() == regNumber) {
                return book;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }


    public int removeBookByRegNumber(int regNumber) {
        Book book;
        Iterator<Book> booksIter = booksCatalogSet.iterator();

        while (booksIter.hasNext()) {

            if (booksIter.next().getRegNumber() == regNumber) {
                booksIter.remove();
                return regNumber;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }


    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> booksByAuthorSet = new HashSet<>();

        Book book;
        Iterator<Book> booksIter = booksCatalogSet.iterator();

        while (booksIter.hasNext()) {
            book = booksIter.next();
            if (book.getAuthor().equals(author)) {
                booksByAuthorSet.add(book);
            }
        }
        if (booksByAuthorSet.isEmpty()) {
            throw new MissingBookException("No books found by " + author);
        }
        return booksByAuthorSet;
    }


    public int libraryBooksCount() {
        return booksCatalogSet.size();
    }


}
