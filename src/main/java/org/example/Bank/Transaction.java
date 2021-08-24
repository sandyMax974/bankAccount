package org.example.Bank;
import java.time.LocalDate;

public class Transaction {

    private final LocalDate date;
    private final Integer credit;
    private final Integer debit;
    private final Integer balance;

    public Transaction(LocalDate date, Integer credit, Integer debit, Integer balance) {
        this.date = date;
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;
    }

}
