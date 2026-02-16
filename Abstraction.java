// Abstraction - Hiding implementation details and showing only functionality
// Achieved through: Abstract classes and Interfaces

// ===== ABSTRACT CLASS =====
// Cannot create object of abstract class
// Can have both abstract and concrete methods
abstract class BankAccount {
    String accountNumber;
    double balance;
    
    // Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }  
    
    // Abstract method (no implementation)
    abstract void calculateInterest();
    
    // Concrete method (with implementation)
    void displayBalance() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}     

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    
    // Must implement abstract method
    @Override
    void calculateInterest() {
        double interest = balance * 0.04; // 4% interest
        System.out.println("Savings Account Interest (4%): $" + interest);
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    
    // Must implement abstract method
    @Override
    void calculateInterest() {
        double interest = balance * 0.01; // 1% interest
        System.out.println("Current Account Interest (1%): $" + interest);
    }
}

// ===== INTERFACE =====
// 100% abstraction (all methods are abstract by default)
// Can have only abstract methods (before Java 8)
interface Payment {
    void processPayment(double amount);
    void generateReceipt();
}

class CreditCardPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card payment: $" + amount);
    }
    
    @Override
    public void generateReceipt() {
        System.out.println("Credit Card receipt generated");
    }
}

class UPIPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment: $" + amount);
    }
    
    @Override
    public void generateReceipt() {
        System.out.println("UPI receipt generated");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        System.out.println("=== ABSTRACTION EXAMPLES ===\n");
        
        // Abstract Class Example
        System.out.println("1. ABSTRACT CLASS EXAMPLE:");
        System.out.println("(Hiding how interest is calculated, showing only the result)\n");
        
        BankAccount savings = new SavingsAccount("SAV001", 10000);
        savings.displayBalance();
        savings.calculateInterest();
        
        System.out.println();
        
        BankAccount current = new CurrentAccount("CUR001", 50000);
        current.displayBalance();
        current.calculateInterest();
        
        // Interface Example
        System.out.println("\n2. INTERFACE EXAMPLE:");
        System.out.println("(Hiding payment processing details, showing only the action)\n");
        
        Payment payment1 = new CreditCardPayment();
        payment1.processPayment(5000);
        payment1.generateReceipt();
        
        System.out.println();
        
        Payment payment2 = new UPIPayment();
        payment2.processPayment(3000);
        payment2.generateReceipt();
        
        System.out.println("\nBenefit: Users interact with simple methods without knowing complex implementation!");
        
        System.out.println("\n=== KEY DIFFERENCES ===");
        System.out.println("Abstract Class: Can have both abstract and concrete methods");
        System.out.println("Interface: All methods are abstract (100% abstraction)");
    }
}
