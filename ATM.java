import java.util.Scanner;

public class ATM {
    private BankServer bankServer;

    public ATM() {
        bankServer = new BankServer();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the ATM");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (bankServer.login(username, password)) {
                System.out.println("Login successful!");
                User user = bankServer.getLoggedInUser ();
                boolean exit = false;

                while (!exit) {
                    System.out.println("\n1. Get Balance");
                    System.out.println("2. Withdraw Cash");
                    System.out.println("3. Deposit Cash");
                    System.out.println("4. Logout");
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    switch (choice) {
                        case 1:
                            System.out.println("Current Balance: $" + user.getBalance());
                            break;
                        case 2:
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = scanner.nextDouble();
                            scanner.nextLine(); // Consume the newline character
                            if (user.withdraw(withdrawAmount)) {
                                System.out.println("Withdrawal successful! New Balance: $" + user.getBalance());
                            } else {
                                System.out.println("Insufficient funds!");
                            }
                            break;
                        case 3:
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = scanner.nextDouble();
                            scanner.nextLine(); // Consume the newline character
                            user.deposit(depositAmount);
                            System.out.println("Deposit successful! New Balance: $" + user.getBalance());
                            break;
                        case 4:
                            bankServer.logout();
                            System.out.println("Logged out successfully.");
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}