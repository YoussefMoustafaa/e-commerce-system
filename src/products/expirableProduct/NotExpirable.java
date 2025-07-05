package products.expirableProduct;

import java.time.LocalDate;

public class NotExpirable implements IExpirable {
    private String productName;

    public NotExpirable(String name) {
        this.productName = name;
    }
    
    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public void printExpirationInfo() {
        throw new UnsupportedOperationException(this.productName + " has no expiration date!");
    }

    @Override
    public LocalDate getExpirationDate() {
        throw new UnsupportedOperationException(this.productName + " has no expiration date!");
    }
}
