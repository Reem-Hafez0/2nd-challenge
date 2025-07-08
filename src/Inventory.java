import java.util.*;

public class Inventory {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void removeOutdatedBooks(int maxYearsOld, int currentYear) {
        books.values().removeIf(book -> currentYear - book.getYear() > maxYearsOld);
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }
}
