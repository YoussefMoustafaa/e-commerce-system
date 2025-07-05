package products;
import java.time.LocalDate;

import products.expirableProduct.IExpirable;
import products.expirableProduct.NotExpirable;
import products.shippableProduct.IShippable;
import products.shippableProduct.NotShippable;

public class Product {
    private String name;
    private double price;
    private int quantity;
    
    // Composition with behaviors
    private IExpirable expirableProduct;
    private IShippable shippableProduct;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        shippableProduct = new NotShippable(name);
        expirableProduct = new NotExpirable(name);
    }

    public void setExpirableBehavior(IExpirable iExpirableProduct) {
        this.expirableProduct = iExpirableProduct;
    }

    public IExpirable getExpirableProduct() {
        return this.expirableProduct;
    }

    public void setShippableBehavior(IShippable iShippableProduct) {
        this.shippableProduct = iShippableProduct;
    }

    public IShippable getShippableProduct() {
        return this.shippableProduct;
    }

    public double getWeight() {
        return this.shippableProduct.getWeight();
    }

    public void setWeight(double weight) {
        this.shippableProduct.setWeight(weight);
    }

    public boolean checkExpiry() {
        return this.expirableProduct.isExpired();
    }

    public LocalDate getExpirationDate() {
        return this.expirableProduct.getExpirationDate();
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
