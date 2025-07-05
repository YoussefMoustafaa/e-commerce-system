package products.shippableProduct;
public class NotShippable implements IShippable {
    private String productName;

    public NotShippable(String name) {
        this.productName = name;
    }

    @Override
    public double getWeight() {
        return 0.0;
    }

    @Override
    public void setWeight(double weight) {
        throw new UnsupportedOperationException(this.productName + " does not require shipping!");
    }

    @Override
    public String getName() {
        return this.productName;
    }
}
