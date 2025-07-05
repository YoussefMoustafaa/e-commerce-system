public class ShippableProduct implements IShippable {
    private double weight;

    public ShippableProduct(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
