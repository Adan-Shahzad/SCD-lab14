class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
public class PracticeTask2 {
    private double balance;
    
    public BankingSystem(double initialBalance) {
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Error: Insufficient balance! Requested: $" + amount + 
                ", Available: $" + balance
            );
        }
        
        if (amount <= 0) {
            throw new InsufficientBalanceException("Error: Withdrawal amount must be positive!");
        }
        
        balance -= amount;
        System.out.println("Withdrawn: $" + amount);
        System.out.println("New balance: $" + balance);
    }
    
    public double getBalance() {
        return balance;
    }
    
    public static void main(String[] args) {
        BankingSystem account = new BankingSystem(1000.0);
        
        System.out.println("=== Simple Banking System ===");
        System.out.println("Initial balance: $" + account.getBalance());
        
        try {
            System.out.println("\n--- Test 1: Valid withdrawal ---");
            account.withdraw(200);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Transaction completed. Current balance: $" + account.getBalance());
        }
        
        try {
            System.out.println("\n--- Test 2: Insufficient balance ---");
            account.withdraw(900);
        } catch (InsufficientBalanceException e) {
            System.out.println("nO" + e.getMessage());
        } finally {
            System.out.println("Transaction completed. Current balance: $" + account.getBalance());
        }
        
        System.out.println("\n--- Test 3: Deposit then withdraw ---");
        account.deposit(500);
        
        try {
            account.withdraw(300);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Final balance: $" + account.getBalance());
        }
    }
}
