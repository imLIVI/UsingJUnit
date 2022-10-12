import org.junit.jupiter.api.*;

public class CreditAccountTest {
    private Account accountCredit;

    @BeforeAll
    public static void init() {
        System.out.println("Running tests...");
    }

    @BeforeEach
    public void startOfTest() {
        System.out.println("---------------------------------------\n[START OF THE TEST]");
        accountCredit = new CreditAccount();
    }

    @Test
    @DisplayName("Проверка: с Credit Account всегда можно снимать средства")
    public void testPayCreditAccount_success() {
        // Arrange
        int amount = 45;
        // Act
        boolean result = accountCredit.pay(amount);
        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Проверка: Credit Account не может быть >0")
    public void testAddCreditAccount_plusValue_fail() {
        // Arrange
        int amount = 50, expected = 0;
        // Act
        accountCredit.addMoney(amount);
        int result = accountCredit.getBalance();

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка: пополнение Credit Account до суммы, не превышающей 0")
    public void testAddCreditAccount_success() {
        // Arrange
        int amount = 100, addAmount = 50, expected = -50;
        // Act
        accountCredit.pay(amount);
        accountCredit.addMoney(addAmount);
        int result = accountCredit.getBalance();

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка: перевод средств с Credit Account на Savings Account")
    public void testTransferCreditAccount_success() {
        // Arrange
        int amount = 100, expected = -100;
        Account accountSaving = new SavingsAccount();

        // Act
        accountCredit.transfer(accountSaving, amount);
        int result = accountCredit.getBalance();

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @AfterEach
    public void endOfTest() {
        System.out.println("[END OF THE TEST]\n---------------------------------------");
    }
}
