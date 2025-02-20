public class User implements ATMInterface {
    private String username;
    private String password;
    private double balance;

    public User(String username, String password, double initialBalance) {
        this.username = username;
        this.password = password;
        this.balance = initialBalance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }
}