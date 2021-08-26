package org.example.Bank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Account {
    public static ArrayList<Transaction> transactions;
    private Double overdraft;

    public Account() {
        transactions = new ArrayList<Transaction>();
        overdraft = 0.00;
    }

    public void modifyOverdraft(Double value) {
        overdraft = value;
    }

    public Double getCurrentBalance() {
        Double currentBalance = 0.00;
        for (Integer i = 0; i < transactions.size(); i++) {
            if(transactions.get(i).getTransactionCredit() != null) { currentBalance += transactions.get(i).getTransactionCredit(); }
            if(transactions.get(i).getTransactionDebit() != null) { currentBalance -= transactions.get(i).getTransactionDebit(); }
        }
        return currentBalance;
    }

    private void addTransactionToAccount(Transaction transaction) {
        transactions.add(transaction);
    }

    public void withdraw(Double amount, LocalDate date) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Cannot withdraw negative amount");
        } else {
            Double balanceAfterTransaction = getCurrentBalance() - amount;
            if(balanceAfterTransaction < -overdraft) {
                throw new ArithmeticException("Unauthorized operation, insufficient fund");
            } else {
                Transaction deposit_transaction = new Transaction(date, null, amount, balanceAfterTransaction);
                addTransactionToAccount(deposit_transaction);
            }
        }
    }
    public void withdraw(Double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Cannot withdraw negative amount");
        } else {
            Double balanceAfterTransaction = getCurrentBalance() - amount;
            if(balanceAfterTransaction < -overdraft) {
                throw new ArithmeticException("Unauthorized operation, insufficient fund");
            } else {
                Transaction deposit_transaction = new Transaction(LocalDate.now(), null, amount, balanceAfterTransaction);
                addTransactionToAccount(deposit_transaction);
            }
        }
    }

    public void deposit(Double amount, LocalDate date) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Cannot deposit negative amount");
        } else {
            Double balanceAfterTransaction = getCurrentBalance() + amount;
            Transaction deposit_transaction = new Transaction(date, amount, null, balanceAfterTransaction);
            addTransactionToAccount(deposit_transaction);
        }
    }
    public void deposit(Double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Cannot deposit negative amount");
        } else {
            Double balanceAfterTransaction = getCurrentBalance() + amount;
            Transaction deposit_transaction = new Transaction(LocalDate.now(), amount, null, balanceAfterTransaction);
            addTransactionToAccount(deposit_transaction);
        }
    }


    public void printStatement() {
        Statement statement = new Statement();
        statement.printStatementHeader();

        transactions.sort(Comparator.comparing(Transaction::getTransactionDate).reversed());
        for(int i = 0; i < transactions.size(); i++) {
            String statementLineDate = statement.printGeTransactionDate(transactions.get(i));
            String statementLineBalance = statement.printGeTransactionBalance(transactions.get(i));
            String statementLineCredit = statement.printGeTransactionCredit(transactions.get(i));
            String statementLineDebit = statement.printGeTransactionDebit(transactions.get(i));

            statement.printStatementData(statementLineDate, statementLineCredit,statementLineDebit,statementLineBalance);
        }
    }
}
