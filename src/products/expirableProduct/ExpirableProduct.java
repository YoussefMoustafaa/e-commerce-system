package products.expirableProduct;
import java.time.LocalDate;

public class ExpirableProduct implements IExpirable {
    private LocalDate expirationDate;
    private String productName;

    public ExpirableProduct(String name, LocalDate expirationDate) {
        this.expirationDate = expirationDate;
        this.productName = name;
    }

    @Override
    public boolean isExpired() {
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid product name");
        }
        return LocalDate.now().isAfter(expirationDate);
    }

    @Override
    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    @Override
    public void printExpirationInfo() {
        if (isExpired()) {
            System.out.println(this.productName + " has expired on " + this.expirationDate);
        } else {
            System.out.println(this.productName + " is still valid until " + this.expirationDate);
        }
    }
}
