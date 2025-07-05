package shipping;
import java.util.HashMap;
import java.util.Map;

import products.shippableProduct.IShippable;
import cart.Cart;



public class ShippingService {
    private Map<IShippable, Integer> shippingList = new HashMap<>();

    
    public void setShippingList(Map<IShippable, Integer> shippables) {
        this.shippingList.clear();
        this.shippingList.putAll(shippables);
    }


    public Map<IShippable, Integer> getShippingList() {
        return this.shippingList;
    }

    public void printShipmentNotice(Cart cart) {
        ShippingView.printShipmentNotice(cart);
    }

    public void collectShippableItems(Cart cart) {
        this.shippingList.putAll(ShippingListBuilder.collectShippableItems(cart));
    }
}
