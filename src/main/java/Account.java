public abstract class Account {
    private int balance;
    private String nameOfAccount;

    public abstract String getName();

    public abstract int getBalance();

    public abstract boolean pay(int amount);

    public abstract void transfer(Account account, int amount);

    public abstract void addMoney(int amount);

}
