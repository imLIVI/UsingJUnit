import org.junit.jupiter.api.*;

public class CheckingAccountTest {
    private Account accountChecking;

    @BeforeAll
    public static void init() {
        System.out.println("Running tests...");
    }

    @BeforeEach
    public void startOfTest() {
        System.out.println("---------------------------------------\n[START OF THE TEST]");
        accountChecking = new CheckingAccount();
    }

    @Test
    @DisplayName("Проверка: Checking Account не может быть < 0")
    public void testPayCheckingAccount_minusValue_fail() {
        // Arrange
        int amount = 45;
        // Act
        boolean result = accountChecking.pay(amount);
        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Проверка: с Checking Account можно снимать, если остаток > 0")
    public void testPayCheckingAccount_success() {
        // Arrange
        int amount = 45, addAmount = 50;
        // Act
        accountChecking.addMoney(addAmount);
        boolean result = accountChecking.pay(amount);
        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Проверка: Checking Account всегда можно пополнять")
    public void testAddCheckingAccount_success() {
        // Arrange
        int amount = 50, expected = 50;
        // Act
        accountChecking.addMoney(amount);
        int result = accountChecking.getBalance();

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка: c Checking Account нельзя перевести средства, если остаток будет < 0")
    public void testTransferCheckingAccount_minusValue_fail() {
        // Arrange
        int amount = 100, expected = 0;
        Account accountSaving = new SavingsAccount();

        // Act
        accountChecking.transfer(accountSaving, amount);
        int result = accountChecking.getBalance();

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка: на Credit Account нельзя выполнить перевод, потому что Credit Account будет > 0")
    public void testTransferCheckingAccount_plusCreditAccount_fail() {
        // Arrange
        int amount = 500, transferAmount = 100, expected = 500;
        Account accountCredit = new CreditAccount();

        // Act
        accountChecking.addMoney(amount);
        accountChecking.transfer(accountCredit, transferAmount);
        int result = accountChecking.getBalance();

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка: успешный перевод")
    public void testTransferCheckingAccount_success() {
        // Arrange
        int amount = 500, transferAmount = 100, expected = 400;
        Account accountSaving = new SavingsAccount();

        // Act
        accountChecking.addMoney(amount);
        accountChecking.transfer(accountSaving, transferAmount);
        int result = accountChecking.getBalance();

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @AfterEach
    public void endOfTest() {
        System.out.println("[END OF THE TEST]\n---------------------------------------");
    }
}
