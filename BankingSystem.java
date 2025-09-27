/* Description: Create a banking system with different account types:
Define an abstract class BankAccount with fields like accountNumber, holderName, and balance.
Add methods like deposit(double amount) and withdraw(double amount) (concrete) and calculateInterest() (abstract).
Implement subclasses SavingsAccount and CurrentAccount with unique interest calculations.
Create an interface Loanable with methods applyForLoan() and calculateLoanEligibility().
Use encapsulation to secure account details and restrict unauthorized access.
Demonstrate polymorphism by processing different account types and calculating interest dynamically.
 */
abstract class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;

    BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New Balance: " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public abstract double calculateInterest();

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

interface Loanable {
    void applyForLoan(double requestedAmount);

    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    SavingsAccount(int accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 2;
    }

    @Override
    public void applyForLoan(double requestedAmount) {
        double eligibleAmount = calculateLoanEligibility();
        if (requestedAmount <= eligibleAmount) {
            System.out.println("Loan approved for: " + requestedAmount);
        } else {
            System.out.println("Loan denied! Max eligible loan: " + eligibleAmount);
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Interest Earned: " + calculateInterest());
        System.out.println("Max Loan Eligibility: " + calculateLoanEligibility());
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate;

    CurrentAccount(int accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 3;
    }

    @Override
    public void applyForLoan(double requestedAmount) {
        double eligibleAmount = calculateLoanEligibility();
        if (requestedAmount <= eligibleAmount) {
            System.out.println("Loan approved for: " + requestedAmount);
        } else {
            System.out.println("Loan denied! Max eligible loan: " + eligibleAmount);
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Interest Earned: " + calculateInterest());
        System.out.println("Max Loan Eligibility: " + calculateLoanEligibility());
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount(110, "Diksha", 65000, 5);
        BankAccount acc2 = new CurrentAccount(112, "Kamal", 75000, 2);

        acc1.display();
        ((Loanable) acc1).applyForLoan(100000);

        System.out.println();

        acc2.display();
        ((Loanable) acc2).applyForLoan(200000);
        acc2.deposit(20000);
    }
}
