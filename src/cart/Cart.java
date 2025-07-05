package cart;
import java.util.Map;

import products.Product;

import java.util.HashMap;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        try {
            CartValidator.validateProduct(product, quantity);
            products.put(product, quantity);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void removeProduct(Product product) {
        try {
            if (!isProductInCart(product)) {
                throw new Exception(product.getName() + " is not in cart!");
            }
            products.remove(product);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
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
