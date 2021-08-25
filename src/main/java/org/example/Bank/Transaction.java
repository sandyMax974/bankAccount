package org.example.Bank;
import java.time.LocalDate;

public class Transaction {

    public final LocalDate date;
    public final Double credit;
    public final Double debit;
    public final Double balance;

    public Transaction(LocalDate date, Double credit, Double debit, Double balance) {
        this.date = date;
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;
    }

    public LocalDate getTransactionDate() {
        return this.date;
    }

//    @Override
//    public int compareTo(Transaction o) {
//        if(getTransactionDate() == null || o.getTransactionDate() == null) {
//            return 0;
//        }
//        return getTransactionDate().compareTo(o.getTransactionDate());
//    }
}
