import java.time.LocalDate;

public class ExpirableProduct implements IExpirable {
    private LocalDate expirationDate;

    public ExpirableProduct(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isExpired(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid product name");
        }
        return LocalDate.now().isAfter(expirationDate);
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void printExpirationInfo(String productName) {
        if (isExpired(productName)) {
            System.out.println(productName + " has expired on " + expirationDate);
        } else {
            System.out.println(productName + " is still valid until " + expirationDate);
        }
    }
}
