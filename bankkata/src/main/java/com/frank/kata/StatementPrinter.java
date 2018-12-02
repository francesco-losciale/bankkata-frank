package com.frank.kata;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatementPrinter {

    private Console console;
    private DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactionList) {
        printHeader();
        printStatementLines(transactionList);
    }

    private void printStatementLines(List<Transaction> transactionList) {
        AtomicInteger runningBalance = new AtomicInteger(0);
        transactionList.stream()
                .map(transaction -> transactionAsLine(transaction, runningBalance))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(console::printLine);
    }

    private void printHeader() {
        String header = "DATE | AMOUNT | BALANCE";
        console.printLine(header);
    }

    private String transactionAsLine(Transaction transaction, AtomicInteger runningBalance) {
        return transaction.getDate() + " | " + decimalFormat.format(transaction.getAmount()) + " | " + decimalFormat.format(runningBalance.addAndGet(transaction.getAmount()));
    }
}
