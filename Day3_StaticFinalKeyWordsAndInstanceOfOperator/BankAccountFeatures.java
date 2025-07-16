package Day3_StaticFinalKeyWordsAndInstanceOfOperator;

public class BankAccountFeatures {
    private static String bankName = "BridgeLabz Bank";
    private static int totalAccounts = 0;

    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccountFeatures(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++;
    }

    public static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    public void displayAccountDetails() {
        if (this instanceof BankAccountFeatures) {
            System.out.println("Bank: " + bankName + ", Account Number: " + accountNumber +
                    ", Account Holder: " + accountHolderName + ", Balance: " + balance);
        } else {
            System.out.println("Not a valid BankAccountFeatures object.");
        }
    }

    public static void main(String[] args) {
        BankAccountFeatures acc1 = new BankAccountFeatures("12345", "Alice", 10000.0);
        BankAccountFeatures acc2 = new BankAccountFeatures("67890", "Bob", 20000.0);

        acc1.displayAccountDetails();
        acc2.displayAccountDetails();

        BankAccountFeatures.getTotalAccounts();
    }
}