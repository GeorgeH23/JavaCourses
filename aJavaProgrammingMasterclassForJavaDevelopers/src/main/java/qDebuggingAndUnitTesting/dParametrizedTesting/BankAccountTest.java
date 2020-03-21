package qDebuggingAndUnitTesting.dParametrizedTesting;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount bankAccount;
    private static int count;

    // This method runs just one time, before any other test method in the class.
    // It can be used to initialize properties which could be used in all the other test methods.
    @BeforeAll
    public static void beforeClass(){
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    // This method runs before each test method in the BankAccountTest class.
    @BeforeEach
    public void setup(){
        bankAccount = new BankAccount("Tim", "Bengos", 1000.00, BankAccount.CHCECKING);
        System.out.println("Running a test...");
    }

    @Test
    public void deposit() {

        double balance = bankAccount.deposit(200.00, true);
        assertEquals(1200.00, balance, 0.1);
    }

    @Test
    public void withdraw_atBranch() throws Exception {
        double balance = bankAccount.withdraw(600.00, true);
        assertEquals(400.00, balance, 0.1);
    }

    @Test
    public void withdraw_notBranch() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(600.00, false);
        });
    }

    @Test
    public void getBalance_deposit() {

        bankAccount.deposit(200.00, true);
        assertEquals(1200.00, bankAccount.getBalance(), 0.1);
    }

    @Test
    public void getBalance_withdraw() {

        bankAccount.withdraw(200.00, true);
        assertEquals(800.00, bankAccount.getBalance(), 0.1);
    }

    @Test
    public void isChecking_true() {
        assertTrue(bankAccount.isChecking(), "The account is NOT a checking account.");
    }

    // This method runs after each test method in the BankAccountTest class.
    @AfterEach
    public void teardown(){
        System.out.println("Count = " + count++);
    }

    // This method runs just one time, after any other test method in the class.
    @AfterAll
    public static void afterClass() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }
}