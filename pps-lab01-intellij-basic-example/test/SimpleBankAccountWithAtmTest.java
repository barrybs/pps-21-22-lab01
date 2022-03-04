import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends AbstractBankAccountTest{

    @BeforeEach
    @Override
    public void setUp(){
        setAccountHolder(new AccountHolder("Mario", "Rossi", 1));
        setBankAccount(new SimpleBankAccountWithAtm(getAccountHolder(), 0));
    }

    @Test
    void testWithdraw() {
        getBankAccount().deposit(getAccountHolder().getId(), 100);
        getBankAccount().withdraw(getAccountHolder().getId(), 70);
        assertEquals(29, getBankAccount().getBalance());
    }

}
