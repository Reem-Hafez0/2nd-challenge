public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        QuantumBookstore store = new QuantumBookstore();

        Book paper = new PaperBook("001", "Java Basics", 2015, 120.0, "John Doe", 10);
        Book ebook = new EBook("002", "Learn Python", 2018, 90.0, "Jane Smith", "PDF");
        Book demo = new ShowcaseBook("003", "C++ Demo", 2000, 0.0, "No One");

        store.addBook(paper);
        store.addBook(ebook);
        store.addBook(demo);

        try {
            double paid = store.buyBook("001", 2, "user@example.com", "123 Street");
            System.out.println("Quantum book store: Paid amount = " + paid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            store.buyBook("003", 1, "demo@example.com", "321 Road");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        store.removeOutdated(10, 2025);
    }
}
