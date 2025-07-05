package shipping;

import java.util.Map;

import cart.Cart;
import cart.CartCalculator;
import products.shippableProduct.IShippable;

public class ShippingView {
    public static void printShipmentNotice(Cart cart) {
        Map<IShippable, Integer> shippingList = ShippingListBuilder.collectShippableItems(cart);
        if (shippingList.isEmpty()) {
            System.out.println("** No items to ship **");
            return;
        }
        System.out.println("** Shipment notice **");
        for (Map.Entry<IShippable, Integer> entry : shippingList.entrySet()) {
            IShippable shippable = entry.getKey();
            System.out.println(entry.getValue() + "x " + shippable.getName() + "\t\t" + shippable.getWeight() * entry.getValue() + "g");
        }

        System.out.println("Total package weight " + CartCalculator.calculateTotalWeight(cart) + "kg");
    }
}
