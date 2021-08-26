package org.example.Bank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Account {
    public static ArrayList<Transaction> transactions;
    public Double overdraft;

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

    public void addTransactionToAccount(Transaction transaction) {
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

    public void deposit(Double amount, LocalDate date) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Cannot deposit negative amount");
        } else {
            Double balanceAfterTransaction = getCurrentBalance() + amount;
            Transaction deposit_transaction = new Transaction(date, amount, null, balanceAfterTransaction);
            addTransactionToAccount(deposit_transaction);
        }
    }

    void printStatementHeader() {
        String statementHeader = "date || credit || debit || balance";
        System.out.println(statementHeader);
    }

    void printStatementData(String transactionDate, String transactionCredit, String transactionDebit, String transactionBalance) {
        String statementLine = String.format("%s || %s || %s || %s",transactionDate, transactionCredit,transactionDebit,transactionBalance);
        System.out.println(statementLine);
    }

    public void printStatement() {
        printStatementHeader();
        transactions.sort(Comparator.comparing(Transaction::getTransactionDate).reversed());
        for(int i = 0; i < transactions.size(); i++) {
            String statementLineDate = String.valueOf(transactions.get(i).getTransactionDate());
            String statementLineBalance = String.valueOf(transactions.get(i).getBalanceAfterTransaction());

//            System.out.println(transactions.get(i).getBalanceAfterTransaction().getClass());

            String statementLineCredit;
            if(transactions.get(i).getTransactionCredit() == null) {
                statementLineCredit = "-";
            } else {
                statementLineCredit = String.valueOf(transactions.get(i).getTransactionCredit());
            }

            String statementLineDebit;
            if(transactions.get(i).getTransactionDebit() == null) {
                statementLineDebit = "-";
            } else {
                statementLineDebit = String.valueOf(transactions.get(i).getTransactionDebit());
            }

            printStatementData(statementLineDate, statementLineCredit,statementLineDebit,statementLineBalance);
        }
    }
}
