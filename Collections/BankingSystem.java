import java.util.*;

public class BankingSystem {

    private Map<Integer, Double> accounts = new HashMap<>();
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void addAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.offer(accountNumber);
        }
    }

    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            double balance = accounts.get(accountNumber);
            if (balance >= amount) {
                accounts.put(accountNumber, balance - amount);
                System.out.println("Withdrawal of " + amount + " successful for account " + accountNumber);
            } else {
                System.out.println("Insufficient balance for account " + accountNumber);
            }
        }
    }

    public void displayAccountsSortedByBalance() {
        TreeMap<Double, List<Integer>> sortedAccounts = new TreeMap<>();

        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            double balance = entry.getValue();
            int accNo = entry.getKey();
            sortedAccounts.putIfAbsent(balance, new ArrayList<>());
            sortedAccounts.get(balance).add(accNo);
        }

        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Double, List<Integer>> entry : sortedAccounts.entrySet()) {
            double balance = entry.getKey();
            for (int acc : entry.getValue()) {
                System.out.println("Account " + acc + " : - " + balance);
            }
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount(1001, 5000);
        bank.addAccount(1002, 3000);
        bank.addAccount(1003, 7000);

        bank.requestWithdrawal(1001);
        bank.requestWithdrawal(1002);
        bank.requestWithdrawal(1003);

        bank.processWithdrawals(2000);

        bank.displayAccountsSortedByBalance();
    }
}
