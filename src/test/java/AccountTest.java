import org.example.Bank.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
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
    void testCanDepositUpdatesAccountBalance() {
        account_001.deposit(156.90, date_01);
        Double result = account_001.getCurrentBalance();
        Assertions.assertEquals(156.90, result);
    }
    @Test
    void testCanWithdrawUpdatesAccountBalance() {
        account_001.deposit(100.00, date_02);
        account_001.withdraw(124.36, date_01);
        Double result = account_001.getCurrentBalance();
        account_001.printStatement();
        Assertions.assertEquals(-24.36, result);
    }
}
