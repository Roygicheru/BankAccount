package io.github.roygicheru.BankAccount;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        setAccountNumber(accountNumber);
        setAccountHolder(accountHolder);
        setBalance(balance);
    }
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber != null && accountNumber.length() == 6 && accountNumber.matches("a1b2c3")) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("Account number must be exactly 6 alphanumeric characters!");
        }
    }

    public void setAccountHolder(String accountHolder) {
        if (accountHolder != null && accountHolder.trim().length() > 2) {
            this.accountHolder = accountHolder;
        } else {
            System.out.println("Account holder name must contain at least 2 letters and not be empty!");
        }
    }

    // Method to set balance
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative!");
        }
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Deposited " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0) {
            if (getBalance() >= amount) {
                setBalance(getBalance() - amount);
                System.out.println("Withdrawn " + amount);
            } else {
                System.out.println("Insufficient funds! Balance is " + getBalance());
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to display the current balance
    public void getLatestBalance() {
        System.out.println("The balance of user "+ getAccountHolder() + " of account number " + getAccountNumber() +" is " + getBalance());
    }
}
