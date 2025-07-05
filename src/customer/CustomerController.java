package customer;

import cart.Cart;
import products.Product;

public class CustomerController {

    public static void deductBalance(Customer customer, double amount) {
        try {
            if (!customer.canAfford(amount)) {
                throw new Exception("Insufficient balance!");
            }
            customer.setBalance(customer.getBalance() - amount);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void addToCart(Customer customer, Product product, int quantity) {
        Cart cart = customer.getCart();
        cart.addProduct(product, quantity);
    }
}
