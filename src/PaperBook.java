public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, int year, double price, String author, int stock) {
        super(isbn, title, year, price, author);
        this.stock = stock;
    }

    @Override
    public boolean isAvailable() {
        return stock > 0;
    }

    public void reduceStock(int quantity) {
        if (stock < quantity)
            throw new IllegalArgumentException("Quantum book store: Not enough stock.");
        stock -= quantity;
    }

    @Override
    public void handleDelivery(String email, String address) {
        ShippingService.send(address);
    }
}
