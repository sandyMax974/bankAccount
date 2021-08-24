import org.example.Bank.Account;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;

public class AccountTest {

    LocalDate date = LocalDate.of(2021, 8, 14);

    @Test
    void testDeposit() {
        Account account_001 = new Account();
        account_001.deposit(156.90, date);
        Double result = account_001.transactions.get(0).balance;
        Assertions.assertEquals(156.90, result);
    }
    @Test
    void testWithdraw() {
        Account account_001 = new Account();
        account_001.withdraw(124.36, date);
        Double result = account_001.transactions.get(0).balance;
        Assertions.assertEquals(-124.36, result);
    }

}
