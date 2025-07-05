package products.shippableProduct;
public class ShippableProduct implements IShippable {
    private double weight;
    private String productName;

    public ShippableProduct(String name, double weight) {
        this.weight = weight;
        this.productName = name;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getName() {
        return this.productName;
    }
}
