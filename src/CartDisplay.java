import java.util.Map;

public class CartDisplay {

    public static void printShipmentNotice(Cart cart) {
        System.out.println("** Shipment notice **");

        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product product = entry.getKey();
            System.out.println(entry.getValue() + "x " + product.getName() + "\t" + product.getWeight() + "g");
        }

        System.out.println("Total package weight " + CartCalculator.calculateTotalWeight(cart) + "kg");
    }

    public static void printCheckoutReceipt(Cart cart) {
        System.out.println("** Checkout receipt **");

        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product product = entry.getKey();
            System.out.println(entry.getValue() + "x " + product.getName() + "\t $" + product.getPrice());
        }
    }

    public static void printFees(Cart cart) {
        System.out.println("Subtotal \t $" + CartCalculator.calculateSubTotal(cart));

        System.out.println("Shipping \t $" + CartCalculator.calculateShippingFees(cart));

        System.out.println("Amount \t $" + CartCalculator.calculateTotalPrice(cart));
    }
}
