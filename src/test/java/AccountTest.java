import org.example.Bank.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;

public class AccountTest {
    LocalDate date_01 = LocalDate.of(2021, 8, 14);
    LocalDate date_02 = LocalDate.of(2020, 12, 4);
    public Account account_001;

    @BeforeEach
    void setupAccount() {
        account_001 = new Account();
    }

    @Test
    void testDepositUpdatesAccountBalance() {
        account_001.deposit(156.90, date_01);
        Assertions.assertEquals(1, account_001.transactions.size());

        Double result = account_001.getCurrentBalance();
        Assertions.assertEquals(156.90, result);
    }

    @Test
    void testCantDepositNegativeAmount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account_001.deposit(-1.00, date_01);
        });
    }
    @Test
    void testCantWithdrawNegativeAmount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account_001.withdraw(-1.00, date_01);
        });
    }

    @Test
    void testWithdrawUpdatesAccountBalance() {
        account_001.deposit(100.00, date_02);
        account_001.withdraw(24.36, date_01);
        Assertions.assertEquals(2, account_001.transactions.size());

        Double result = account_001.getCurrentBalance();
        Assertions.assertEquals(75.64, result);
    }

    @Test
    @Disabled("Haven't found a simple way to test system output")
    void testPrintStatementIsCorrectFormat() {
        account_001.deposit(1000.00, LocalDate.of(2021, 1, 10));
        account_001.deposit(2000.00, LocalDate.of(2021, 1, 13));
        account_001.withdraw(500.00, LocalDate.of(2021, 1, 14));
        account_001.printStatement();
    }

    @Test
    void testCanWithdrawUpToSpecifiedAccountOverdraft() {
        account_001.modifyOverdraft(50.00);
        account_001.withdraw(40.50, date_01);
        Assertions.assertEquals(1, account_001.transactions.size());

        Double result = account_001.getCurrentBalance();
        Assertions.assertEquals(-40.50, result);
    }
    @Test
    void testCantWithdrawIfOverOverdraft() {
        account_001.modifyOverdraft(30.00);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            account_001.withdraw(40.50, date_01);
        });
        Assertions.assertEquals(0, account_001.transactions.size());
    }
}
