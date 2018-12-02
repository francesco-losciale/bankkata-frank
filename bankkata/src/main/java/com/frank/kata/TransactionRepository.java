package com.frank.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {

    private List<Transaction> transactionList = new ArrayList<>();
    private Clock clock;

    public TransactionRepository(Clock clock) {
        this.clock = clock;
    }

    public List<Transaction> get() {
        return Collections.unmodifiableList(transactionList);
    }

    public void addDeposit(int amount) {
        transactionList.add(new Transaction(clock.todayAsString(), amount));
    }

    public void addWithdrawal(int amount) {
        transactionList.add(new Transaction(clock.todayAsString(), -amount));
    }
}
