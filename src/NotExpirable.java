public class NotExpirable implements IExpirable {
    
    @Override
    public boolean isExpired(String productName) {
        throw new UnsupportedOperationException(productName + " is not expirable!");
    }

    @Override
    public void printExpirationInfo(String productName) {
        throw new UnsupportedOperationException(productName + " has no expiration date!");
    }
}
