package com.frank.kata;


public class Account {

    private StatementPrinter statementPrinter;
    private TransactionRepository transactionRepository;

    public Account(StatementPrinter statementPrinter, TransactionRepository transactionRepository) {
        this.statementPrinter = statementPrinter;
        this.transactionRepository = transactionRepository;
    }

    public void printStatement() {
        statementPrinter.print(transactionRepository.get());
    }

    public void deposit(int amount) {
        this.transactionRepository.addDeposit(amount);
    }

    public void withdrawal(int amount) {
        this.transactionRepository.addWithdrawal(amount);
    }
}
