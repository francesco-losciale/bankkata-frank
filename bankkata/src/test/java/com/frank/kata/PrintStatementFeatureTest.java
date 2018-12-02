package com.frank.kata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeatureTest {

    @Mock Console console;
    @Mock Clock clock;
    private TransactionRepository transactionRepository;

    @Before
    public void setUp() {
        transactionRepository = new TransactionRepository(clock);
    }

    @Test
    public void testPrintStatementUsingCorrectFormat() {
        given(clock.todayAsString()).willReturn("01/04/2014", "02/04/2014", "10/04/2014");
        StatementPrinter statementPrinter = new StatementPrinter(console);
        Account account = new Account(statementPrinter, transactionRepository);
        account.deposit(1000);
        account.withdrawal(100);
        account.deposit(500);
        account.printStatement();

        verify(console).printLine("DATE | AMOUNT | BALANCE");
        verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");

    }
}
