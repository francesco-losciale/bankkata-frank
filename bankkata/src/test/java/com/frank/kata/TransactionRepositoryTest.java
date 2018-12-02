package com.frank.kata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryTest {

    @Mock Clock clock;

    @Test
    public void testStoreTransaction() {
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        transactionRepository.addDeposit(140);
        assertThat(transactionRepository.get().size(), is(1));
    }

    @Test
    public void testStoreDepositTransactionUsingClock() {
        given(clock.todayAsString()).willReturn("01/04/2014", "02/04/2014", "10/04/2014");
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        transactionRepository.addDeposit(140);
        transactionRepository.addDeposit(141);
        transactionRepository.addDeposit(142);

        assertThat(transactionRepository.get().size(), is(3));
        assertThat(transactionRepository.get().get(0), is(new Transaction("01/04/2014", 140)));
        assertThat(transactionRepository.get().get(1), is(new Transaction("02/04/2014", 141)));
        assertThat(transactionRepository.get().get(2), is(new Transaction("10/04/2014", 142)));
    }

    @Test
    public void testStoreWithdrawalTransactionUsingClock() {
        given(clock.todayAsString()).willReturn("01/04/2014", "02/04/2014", "10/04/2014");
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        transactionRepository.addDeposit(140);
        transactionRepository.addWithdrawal(141);
        transactionRepository.addDeposit(142);

        assertThat(transactionRepository.get().size(), is(3));
        assertThat(transactionRepository.get().get(0), is(new Transaction("01/04/2014", 140)));
        assertThat(transactionRepository.get().get(1), is(new Transaction("02/04/2014", -141)));
        assertThat(transactionRepository.get().get(2), is(new Transaction("10/04/2014", 142)));
    }
}
