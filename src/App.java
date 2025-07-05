public class App {


    public void checkout(Customer customer, Cart cart) {
        try {
            if (cart.isCartEmpty()) {
                throw new Exception("Cart is empty. Please add products before checkout.");
            }
            
            CartDisplay.printShipmentNotice(cart);
            System.out.println("\n");

            CartDisplay.printCheckoutReceipt(cart);
            System.out.println("------------------");

            CartDisplay.printFees(cart);

            cart.clearCart();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    public static void main(String[] args) throws Exception {
        Product cheese = new Product("Cheese", 3, 15);
        Product tv = new Product("tv", 500, 3);
    }
}
