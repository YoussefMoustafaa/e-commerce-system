import java.time.LocalDate;

import cart.Cart;
import cart.CartCalculator;
import cart.CartDisplay;
import customer.Customer;
import customer.CustomerController;
import products.Product;
import products.expirableProduct.ExpirableProduct;
import products.shippableProduct.ShippableProduct;
import shipping.ShippingService;

public class App {


    public static void checkout(Customer customer, Cart cart) {
        try {
            if (cart.isCartEmpty()) {
                throw new Exception("Cart is empty. Please add products before checkout.");
            }

            ShippingService shippingService = new ShippingService();
            
            shippingService.printShipmentNotice(cart);
            System.out.println("\n");

            CartDisplay.printCheckoutReceipt(cart);
            System.out.println("--------------------------");

            CartDisplay.printFees(cart);

            double amount = CartCalculator.calculateTotalPrice(cart);

            cart.clearCart();

            CustomerController.deductBalance(customer, amount);

            System.out.println("Current balance after payment: \t $" + customer.getBalance());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    public static void main(String[] args) throws Exception {

        Customer customer = new Customer("Youssef", 5000, "Nasr City");
        Cart cart = new Cart();

        Product cheese = new Product("Cheese", 2.5, 15);
        cheese.setExpirableBehavior(new ExpirableProduct(cheese.getName(), LocalDate.of(2025, 1, 23)));
        cheese.setShippableBehavior(new ShippableProduct(cheese.getName(), 400));

        Product tv = new Product("Samsung tv", 500, 5);
        tv.setShippableBehavior(new ShippableProduct(tv.getName(), 5000));


        Product biscuits = new Product("Biscuits", 1.2, 25);
        biscuits.setExpirableBehavior(new ExpirableProduct(biscuits.getName(), LocalDate.of(2025, 10, 21)));
        biscuits.setShippableBehavior(new ShippableProduct(biscuits.getName(), 80));

        Product scartchCard = new Product("Scratch Card", 11.64, 10);

        
        cart.addProduct(cheese, 2);
        cart.addProduct(tv, 1);
        cart.addProduct(biscuits, 5);
        cart.addProduct(scartchCard, 2);

        checkout(customer, cart);
    }
}
