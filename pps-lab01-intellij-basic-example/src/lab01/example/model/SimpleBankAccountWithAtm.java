package lab01.example.model;

public class SimpleBankAccountWithAtm extends AbstractBankAccount {

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(balance, holder);
    }

    protected double getFee() {
        return 1;
    }

}
