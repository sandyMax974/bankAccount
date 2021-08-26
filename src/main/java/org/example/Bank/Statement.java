package org.example.Bank;

public class Statement {

    void printStatementHeader() {
        String statementHeader = "date || credit || debit || balance";
        System.out.println(statementHeader);
    }

    void printStatementData(String transactionDate, String transactionCredit, String transactionDebit, String transactionBalance) {
        String statementLine = String.format("%s || %s || %s || %s", transactionDate, transactionCredit, transactionDebit, transactionBalance);
        System.out.println(statementLine);
    }

    String printGeTransactionDate(Transaction transaction) {
        return String.valueOf(transaction.getTransactionDate());
    }

    String printGeTransactionBalance(Transaction transaction) {
        return String.valueOf(transaction.getBalanceAfterTransaction());
    }

    String printGeTransactionCredit(Transaction transaction) {
        if (transaction.getTransactionCredit() == null) {
            return "-";
        } else {
            return String.valueOf(transaction.getTransactionCredit());
        }
    }

    String printGeTransactionDebit(Transaction transaction) {
        if (transaction.getTransactionDebit() == null) {
            return "-";
        } else {
            return String.valueOf(transaction.getTransactionDebit());
        }
    }
}
