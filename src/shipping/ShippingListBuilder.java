package shipping;

import java.util.HashMap;
import java.util.Map;

import cart.Cart;
import products.Product;
import products.shippableProduct.IShippable;

public class ShippingListBuilder {
    public static Map<IShippable, Integer> collectShippableItems(Cart cart) {
        Map<IShippable, Integer> shippingList = new HashMap<>();
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product product = entry.getKey();
            if (product.getWeight() > 0.0) {
                shippingList.put(product.getShippableProduct(), entry.getValue());
            }
        }
        return shippingList;
    }
}
