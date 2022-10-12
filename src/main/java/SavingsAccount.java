public class SavingsAccount extends Account {
    private int balance;
    private final String nameOfAccount = "Saving Account";

    public SavingsAccount() {
    }

    @Override
    public String getName() {
        return this.nameOfAccount;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("ОШИБКА! С " + this.nameOfAccount + " нельзя платить!");
        return false;
    }

    @Override
    public void transfer(Account account, int amount) {
        int newBalance = this.balance - amount;
        if (newBalance < 0) {
            System.out.println("ОШИБКА! Операция перевода не можнт быть выполнена! " +
                    this.nameOfAccount + " не может быть < 0");
        } else {
            if (account.getName().equals("Credit Account")) {
                if (account.getBalance() + amount > 0) {
                    System.out.println("ОШИБКА! Операция не может быть выполнена, так как " + account.getName()
                            + " должен быть <= 0");
                    return;
                }
            }
            this.balance = newBalance;
            System.out.println("Перевод в размере " + amount + " рублей: "
                    + this.nameOfAccount + " --> " + account.getName());
            account.addMoney(amount);
            System.out.println("Баланс " + this.nameOfAccount + " составляет: " + this.balance + " рублей");
        }
    }

    @Override
    public void addMoney(int amount) {
        System.out.println("Баланс " + this.nameOfAccount + " составляет: " + this.balance + " рублей");
        this.balance += amount;
        System.out.println("После пополнения " + this.nameOfAccount + " Ваш баланс составляет: " + this.balance + " рублей");
    }
}
