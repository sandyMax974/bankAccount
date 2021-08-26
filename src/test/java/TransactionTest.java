import org.example.Bank.Transaction;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;


public class TransactionTest {

    @Test
    void checkTransactionDebitFieldIsPresent() {
        LocalDate date = LocalDate.of(2021, 8, 14);
        Transaction transaction_001 = new Transaction(date, null, 50.60, 150.50);
        Double debit = transaction_001.getTransactionDebit();
        Assertions.assertEquals(50.60, debit);
    }

    @Test
    void checkTransactionBalanceFieldIsPresent() {
        LocalDate date = LocalDate.of(2021, 8, 14);
        Transaction transaction_001 = new Transaction(date, null, 50.60, 150.50);
        Double balance = transaction_001.getBalanceAfterTransaction();
        Assertions.assertEquals(150.50, balance);
    }

    @Test
    void checkTransactionCreditFieldIsPresent() {
        LocalDate date = LocalDate.of(2021, 8, 14);
        Transaction transaction_001 = new Transaction(date, 14.80, null, 150.50);
        Double credit = transaction_001.getTransactionCredit();
        Assertions.assertEquals(14.80, credit);
    }
}
