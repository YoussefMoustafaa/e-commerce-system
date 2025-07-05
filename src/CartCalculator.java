import java.util.Map;

public class CartCalculator {

    // needs handling
    // also needs handling outofstock and expiration
    public static double calculateSubTotal(Cart cart) {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product product = entry.getKey();
            if (!product.isOutOfStock() && !product.checkExpiry()) {
                total += product.getPrice() * product.getQuantity();
            }
        }
        return total;
    }

    public static double calculateTotalWeight(Cart cart) {
        double totalWeight = 0.0;
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product product = entry.getKey();
            if (!product.isOutOfStock() && !product.checkExpiry()) {
                totalWeight += product.getWeight() * product.getQuantity();
            }
        }
        return totalWeight / 1000.0;
    }

    public static double calculateShippingFees(Cart cart) {
        double totalWeight = calculateTotalWeight(cart);
        if (totalWeight <= 1000.0) {
            return 5.0;     // light items
        } else if (totalWeight <= 2000.0) {
            return 10.0;    // medium items
        } else {
            return 20.0;    // heavy items
        }
    }


    public static double calculateTotalPrice(Cart cart) {
        return calculateSubTotal(cart) + calculateShippingFees(cart);
    }
}
