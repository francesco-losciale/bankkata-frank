package com.frank.kata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock Console console;
    @Mock TransactionRepository transactionRepository;

    @Test
    public void testPrintStatement() {
        given(transactionRepository.get()).willReturn(Arrays.asList(new Transaction("10/04/2014", 500)));
        StatementPrinter statementPrinter = new StatementPrinter(console);
        Account account = new Account(statementPrinter, transactionRepository);
        account.printStatement();
        verify(console).printLine("DATE | AMOUNT | BALANCE");
        verify(console).printLine("10/04/2014 | 500.00 | 500.00");
        // ERROR 1: you shouldn't use Console in this test
        // it should be enough to test that StatementPrinter is called when account.printStatement is executed
    }
}
