import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void clearCart() {
        products.clear();
    }

    public boolean isCartEmpty() {
        return products.isEmpty();
    }

    public boolean isProductInCart(Product product) {
        return products.containsKey(product);
    }
}
