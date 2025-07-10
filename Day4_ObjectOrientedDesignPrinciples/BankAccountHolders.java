package Day4_ObjectOrientedDesignPrinciples;

import java.util.*;


public class BankAccountHolders {

    static class Bank {
        private String name;
        private List<Customer> customers;

        public Bank(String name) {
            this.name = name;
            this.customers = new ArrayList<>();
        }

        public void openAccount(Customer customer, BankAccount account) {
            customer.addAccount(account);
            if (!customers.contains(customer)) {
                customers.add(customer);
            }
            System.out.println("Account " + account.getAccountNumber() + " opened for customer " + customer.getName() + " in bank " + name);
        }

        public String getName() {
            return name;
        }

        public List<Customer> getCustomers() {
            return customers;
        }
    }

    static class Customer {
        private String name;
        private List<BankAccount> accounts;

        public Customer(String name) {
            this.name = name;
            this.accounts = new ArrayList<>();
        }

        protected void addAccount(BankAccount account) {
            accounts.add(account);
        }

        public void viewBalances() {
            System.out.println("Balances for customer " + name + ":");
            for (BankAccount acc : accounts) {
                System.out.println("- Account " + acc.getAccountNumber() + ": $" + acc.getBalance());
            }
        }

        public String getName() {
            return name;
        }

        public List<BankAccount> getAccounts() {
            return accounts;
        }
    }

    static class BankAccount {
        private String accountNumber;
        private double balance;
        private Bank bank;

        public BankAccount(String accountNumber, double balance, Bank bank) {
            this.accountNumber = accountNumber;
            this.balance = balance;
            this.bank = bank;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public Bank getBank() {
            return bank;
        }
    }

    public static void main(String[] args) {
        System.out.println("Problem 2: Bank and Account Holders (Association)");
        Bank bank = new Bank("Global Bank");
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        BankAccount acc1 = new BankAccount("ACC1001", 5000.0, bank);
        BankAccount acc2 = new BankAccount("ACC1002", 3000.0, bank);
        BankAccount acc3 = new BankAccount("ACC2001", 7000.0, bank);

        bank.openAccount(customer1, acc1);
        bank.openAccount(customer1, acc2);
        bank.openAccount(customer2, acc3);

        customer1.viewBalances();
        customer2.viewBalances();
    }
}
