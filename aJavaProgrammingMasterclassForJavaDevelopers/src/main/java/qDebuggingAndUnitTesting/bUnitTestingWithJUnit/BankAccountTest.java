package qDebuggingAndUnitTesting.bUnitTestingWithJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankAccountTest {

    @org.junit.jupiter.api.Test
    public void deposit() {
        // fail("This test is yet to be implemented.");
        BankAccount bankAccount = new BankAccount("Tim", "Bengos", 1000.00, BankAccount.CHCECKING);
        double balance = bankAccount.deposit(200.00, true);
        assertEquals(1200.00, balance, 0.1);
    }

    @org.junit.jupiter.api.Test
    public void withdraw() {
        // fail("This test is yet to be implemented.");
        BankAccount bankAccount = new BankAccount("Tim", "Bengos", 1000.00, BankAccount.CHCECKING);
        double balance = bankAccount.withdraw(200.00, true);
        assertEquals(800.00, balance, 0.1);
    }

    @org.junit.jupiter.api.Test
    public void getBalance_deposit() {
        // fail("This test is yet to be implemented.");
        BankAccount bankAccount = new BankAccount("Tim", "Bengos", 1000.00, BankAccount.CHCECKING);
        bankAccount.deposit(200.00, true);
        assertEquals(1200.00, bankAccount.getBalance(), 0.1);
    }

    @org.junit.jupiter.api.Test
    public void getBalance_withdraw() {
        // fail("This test is yet to be implemented.");
        BankAccount bankAccount = new BankAccount("Tim", "Bengos", 1000.00, BankAccount.CHCECKING);
        bankAccount.withdraw(200.00, true);
        assertEquals(800.00, bankAccount.getBalance(), 0.1);
    }

    @org.junit.jupiter.api.Test
    public void isChecking_true() {
        BankAccount bankAccount = new BankAccount("Tim", "Bengos", 1000.00, BankAccount.CHCECKING);
        // BankAccount bankAccount = new BankAccount("Tim", "Bengos", 1000.00, BankAccount.SAVINGS);
        assertTrue(bankAccount.isChecking(), "The account is NOT a checking account.");
    }

    /*@org.junit.jupiter.api.Test
    public void dummyTest() {
        assertEquals(20,21);
    }*/
}