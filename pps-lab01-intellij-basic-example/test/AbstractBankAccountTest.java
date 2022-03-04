import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractBankAccountTest {
    private BankAccount bankAccount;
    private AccountHolder accountHolder;

    @BeforeEach
    public abstract void setUp();

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(2, 50);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(2, 70);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    public void testCanDeposit() {
        SimpleBankAccount bankAccount = new SimpleBankAccount(this.accountHolder,0);
        this.bankAccount.deposit(1, 100);
        assertEquals(100, this.bankAccount.getBalance());
    }

    @Test
    public void testNegativeDeposit() {
        assertThrows(IllegalArgumentException.class, () -> this.bankAccount.deposit(1,-100));
    }

    @Test
    public void testNegativeWithdraw() {
        assertThrows(IllegalArgumentException.class, () -> this.bankAccount.withdraw(1,-100));
    }

    @Test
    public void testNegativeBalance() {
        assertThrows(IllegalStateException.class, () -> this.bankAccount.withdraw(1,100));
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    protected void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    protected void setAccountHolder(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }
}
