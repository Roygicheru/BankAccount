package io.github.roygicheru.BankAccount;

public class BankAccountMain {
    public static void main(String[] args) {
        System.out.println("--- Testing Valid Account ---");
        try {
            // This should succeed
            BankAccount bankAccount = new BankAccount("a1b2c3", "Roy Gicheru", 2000.0);

            bankAccount.deposit(300.0);
            bankAccount.withdraw(100.0);
            bankAccount.getLatestBalance();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Testing Invalid Account ---");
        try {
            // This will fail because "wrong" is not 6 alphanumeric characters
            BankAccount invalidAccount = new BankAccount("wrong", "Roy Gicheru", 500.0);

            // This line will never execute because the exception interrupts the flow
            System.out.println("Account created successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println("Successfully caught the error: " + e.getMessage());
        }
    }
}