package io.github.roygicheru.BankAccount;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("a1b2c3", "Roy Gicheru", 2000.0);

        System.out.println("\nBank Account Details:");
        bankAccount.deposit(300.0);
        bankAccount.withdraw(100.0);
        System.out.println(bankAccount.getBalance());

    }
}
