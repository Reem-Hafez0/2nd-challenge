public class QuantumBookstore {
    private Inventory inventory = new Inventory();

    public void addBook(Book book) {
        inventory.addBook(book);
    }

    public void removeOutdated(int years, int currentYear) {
        inventory.removeOutdatedBooks(years, currentYear);
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.getBook(isbn);
        if (book == null || !book.isAvailable()) {
            throw new IllegalArgumentException("Quantum book store: Book unavailable.");
        }

        if (book instanceof PaperBook) {
            ((PaperBook) book).reduceStock(quantity);
        } else if (book instanceof ShowcaseBook) {
            throw new IllegalArgumentException("Quantum book store: Cannot buy showcase book.");
        }

        double total = book.getPrice() * quantity;
        book.handleDelivery(email, address);
        return total;
    }
}
