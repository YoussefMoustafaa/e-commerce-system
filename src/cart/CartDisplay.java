package cart;
import java.util.Map;

import products.Product;

public class CartDisplay {

    public static void printCheckoutReceipt(Cart cart) {
        System.out.println("** Checkout receipt **");

        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product product = entry.getKey();
            System.out.println(entry.getValue() + "x " + product.getName() + "\t\t $" + product.getPrice());
        }
    }

    public static void printFees(Cart cart) {
        System.out.println("Subtotal \t $" + CartCalculator.calculateSubTotal(cart));

        System.out.println("Shipping \t $" + CartCalculator.calculateShippingFees(cart));

        System.out.println("Amount \t\t $" + CartCalculator.calculateTotalPrice(cart) + "\n");
    }
}
