package qDebuggingAndUnitTesting.dParametrizedTesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTestParameterized {

    private BankAccount account;

    @BeforeEach
    public void setup(){
        account = new BankAccount("Tim", "Bergin", 1000.00, BankAccount.CHCECKING);
        System.out.println("Running a test...");
    }

    @ParameterizedTest
    @MethodSource("withdrawNotBranch")
    public void withdraw_notBranch (double amount, boolean branch) throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(amount, branch);
        });
    }

    @ParameterizedTest
    @MethodSource("getBalanceDeposit")
    public void getBalance_deposit(double amount, boolean branch, double expected) {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0.1);
    }

    @ParameterizedTest
    @MethodSource("getBalanceWithdraw")
    public void getBalance_withdraw(double amount, boolean branch, double expected) {
        account.withdraw(amount, branch);
        assertEquals(expected, account.getBalance(), 0.1);
    }

    private static Stream<Arguments> withdrawNotBranch() {
        return Stream.of(
                Arguments.of(600.00, false),
                Arguments.of(501.00, false),
                Arguments.of(500.01, false)
        );
    }

    private static Stream<Arguments> getBalanceDeposit() {
        return Stream.of(
                Arguments.of(100.00, true, 1100.00),
                Arguments.of(200.00, true, 1200.00),
                Arguments.of(325.14, true, 1325.14),
                Arguments.of(489.33, true, 1489.33),
                Arguments.of(1000.00, true, 2000.00)
        );
    }

    private static Stream<Arguments> getBalanceWithdraw() {
        return Stream.of(
                Arguments.of(100.00, true, 900.00),
                Arguments.of(200.00, true, 800.00),
                Arguments.of(325.14, true, 674.86),
                Arguments.of(489.33, true, 510.67),
                Arguments.of(1000.00, true, 0.00)
        );
    }
}
