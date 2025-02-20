public interface ATMInterface {
    double getBalance();
    boolean withdraw(double amount);
    void deposit(double amount);
}