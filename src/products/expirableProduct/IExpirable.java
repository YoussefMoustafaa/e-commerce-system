package products.expirableProduct;

import java.time.LocalDate;

public interface IExpirable {
    public boolean isExpired();
    public void printExpirationInfo();
    public LocalDate getExpirationDate();
}
