package lab01.example.model;

public abstract class AbstractBankAccount implements BankAccount {
    private double balance;
    private final AccountHolder holder;

    public AbstractBankAccount(final double balance, final AccountHolder holder) {
        this.balance = balance;
        this.holder = holder;
    }

    public AccountHolder getHolder(){
        return this.holder;
    }

    protected abstract double getFee();

    public double getBalance() { return this.balance; }

    public void deposit(final int userID, final double amount) {
        checkNegativeArgument(amount);
        if (checkUser(userID)) this.balance += amount;
    }

    public void withdraw(int userID, final double amount) {
        checkNegativeArgument(amount);
        if (checkUser(userID)) this.balance = this.balance - amount - getFee();
        checkNegativeBalance();
    }

    protected void checkNegativeArgument(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNegativeBalance() {
        if (balance < 0){
            throw new IllegalStateException();
        }
    }
    /*Con i test attuali questo metodo non è utilizzabile
      lo utilizzerò in withdraw() nella prossima release
     */
    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount;
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }

}