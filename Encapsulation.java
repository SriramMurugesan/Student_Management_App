// Encapsulation - Wrapping data (variables) and code (methods) together as a single unit
// Data hiding using private access modifiers and providing public getter/setter methods

class EncapsulatedBankAccount {
    // Private variables - data hiding
    private String accountHolder;
    private double balance;

    // Constructor
    public EncapsulatedBankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public getter method
    public double getBalance() {
        System.out.println("Accessing balance through getter method");
        return balance;
    }

    // Public setter method with validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount");
        }
    }

    // Public method
    public void displayInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        System.out.println("=== ENCAPSULATION EXAMPLE ===");
        System.out.println("Encapsulation means bundling data and methods together");
        System.out.println("and restricting direct access to some components.\n");

        // Creating object
        EncapsulatedBankAccount account = new EncapsulatedBankAccount("John Doe", 1000.0);

        // Cannot access private variables directly
        // account.balance = 5000; // This would give error

        // Must use public methods
        account.displayInfo();
        System.out.println();

        account.deposit(500);
        System.out.println("New Balance: $" + account.getBalance());

        System.out.println("\nBenefit: Data is protected and controlled access is provided!");
    }
}
