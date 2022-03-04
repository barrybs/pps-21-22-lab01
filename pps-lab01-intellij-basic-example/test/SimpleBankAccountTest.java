import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends AbstractBankAccountTest {

    @BeforeEach
    @Override
    public void setUp(){
        setAccountHolder(new AccountHolder("Mario", "Rossi", 1));
        setBankAccount(new SimpleBankAccount(getAccountHolder(), 0));
    }

    @Test
    void testWithdraw() {
        getBankAccount().deposit(getAccountHolder().getId(), 100);
        getBankAccount().withdraw(getAccountHolder().getId(), 70);
        assertEquals(30, getBankAccount().getBalance());
    }

}
