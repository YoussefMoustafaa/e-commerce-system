public class Product {
    private String name;
    private double price;
    private int quantity;
    
    // Composition with behaviors
    private IExpirable expirableProduct = new NotExpirable();
    private IShippable shippableProduct = new NotShippable();

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setExpirableBehavior(IExpirable iExpirableProduct) {
        this.expirableProduct = iExpirableProduct;
    }

    public void setShippableBehavior(IShippable iShippableProduct) {
        this.shippableProduct = iShippableProduct;
    }

    public double getWeight() {
        return this.shippableProduct.getWeight();
    }

    public boolean checkExpiry() {
        return this.expirableProduct.isExpired(this.name);
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isOutOfStock() {
        return (quantity == 0);
    }
}
