public interface IExpirable {
    public boolean isExpired(String productName);
    public void printExpirationInfo(String productName);
}
