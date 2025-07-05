package cart;
import products.Product;

public class CartValidator {
    public static void validateProduct(Product product, int quantity) throws Exception {
        if (product.isOutOfStock()) {
            throw new Exception(product.getName() + " is out of Stock");
        }
        if (quantity > product.getQuantity()) {
            throw new Exception("Available stock for " + product.getName() + " is not enough!");
        }
        if (product.checkExpiry()) {
            throw new Exception(product.getName() + " is expired! \nExpiration date: " + product.getExpirationDate() + "\nRemoved " + product.getName() + " from cart.\n");
        }
    }
}
