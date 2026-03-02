package io.github.roygicheru.BankAccount;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testValidDeposit() {
        BankAccount account = new BankAccount("a1b2c3", "Roy Gicheru", 1000.0);
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), "Balance should increase by 500");
    }

    @Test
    void testValidWithdrawal() {
        BankAccount account = new BankAccount("a1b2c3", "Roy Gicheru", 1000.0);
        account.withdraw(400.0);
        assertEquals(600.0, account.getBalance(), "Balance should decrease by 400");
    }

    @Test
    void testWithdrawMoreThanBalance() {
        BankAccount account = new BankAccount("a1b2c3", "Roy Gicheru", 100.0);
        account.withdraw(200.0);
        assertEquals(100.0, account.getBalance(), "Balance should remain 100 if funds are insufficient");
    }

    @Test
    void testNegativeDeposit() {
        BankAccount account = new BankAccount("a1b2c3", "Roy Gicheru", 1000.0);
        account.deposit(-200.0);
        assertEquals(1000.0, account.getBalance(), "Balance should not change when depositing a negative amount");
    }

    @Test
    void testInvalidAccountNumberThrowsException() {
        // We assert that trying to create an account with an invalid number throws an IllegalArgumentException
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount("wrong", "Roy Gicheru", 100.0);
        });

        // Optionally, verify the exception message matches what we expect
        assertTrue(exception.getMessage().contains("exactly 6 alphanumeric characters"));
    }
}