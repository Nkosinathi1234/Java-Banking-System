import java.util.ArrayList;

public class Accounts {

    private String fullName;
    private String username;
    private String password;
    private double balance;

    // Transaction history
    private ArrayList<String> transactions;


    // Constructor
    public Accounts(String fullName, String username, String password, double balance) {

        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.balance = balance;

        transactions = new ArrayList<>();

        transactions.add("Account created with balance: R" + balance);
    }


    // Getters
    public String getFullName() {
        return fullName;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public double getBalance() {
        return balance;
    }


    // Deposit money
    public void deposit(double amount) {

        if (amount > 0) {

            balance += amount;

            transactions.add("Deposited: R" + amount);

            System.out.printf("Deposit successful! New balance: R%.2f%n", balance);

        } else {

            System.out.println("Invalid deposit amount.");
        }
    }


    // Withdraw money
    public void withdraw(double amount) {

        if (amount <= 0) {

            System.out.println("Invalid withdrawal amount.");

        } else if (amount > balance) {

            System.out.println("Insufficient funds.");

        } else {

            balance -= amount;

            transactions.add("Withdrawn: R" + amount);

            System.out.printf("Withdrawal successful! New balance: R%.2f%n", balance);
        }
    }


    // Display account
    public void displayAccount() {

        System.out.println("\n========== ACCOUNT ==========");
        System.out.println("Name: " + fullName);
        System.out.println("Username: " + username);
        System.out.printf("Balance: R%.2f%n", balance);
        System.out.println("=============================");
    }


    // Display transactions
    public void displayTransactions() {

        System.out.println("\n====== TRANSACTION HISTORY ======");

        if (transactions.isEmpty()) {

            System.out.println("No transactions found.");

        } else {

            for (String transaction : transactions) {

                System.out.println(transaction);
            }
        }

        System.out.println("=================================");
    }
    public String saveFormat() {

    return fullName + "," 
            + username + ","
            + password + ","
            + balance;
}
}