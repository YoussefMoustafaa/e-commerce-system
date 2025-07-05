package customer;
public class Customer {
    private String name;
    private double balance;
    private String address;

    public Customer(String name, double balance, String address) {
        this.name = name;
        this.balance = balance;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean canAfford(double amount) {
        return this.balance >= amount;
    }
}
