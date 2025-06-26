public class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }


    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber + ", Account Holder: " + accountHolder + ", Balance: " + balance);
    }
}


class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displaySavingsAccount() {

        System.out.println("Savings Account Number: " + accountNumber + ", Holder: " + accountHolder + ", Interest Rate: " + interestRate + "%, Balance: " + getBalance());
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("123456", "Alice", 10000.0);
        acc.displayAccount();
        acc.setBalance(12000.0);
        acc.displayAccount();

        SavingsAccount sa = new SavingsAccount("654321", "Bob", 15000.0, 4.5);
        sa.displaySavingsAccount();
    }
}