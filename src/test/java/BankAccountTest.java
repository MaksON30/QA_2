import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    @Test
    public void testCreateBankAccountWithInitialBalance() {
        BankAccount account = new BankAccount(100.0);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawFromAccount() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance(), 0.001);
    }

    @Test
    public void testDepositToAccount() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    public void testInvalidWithdrawal() {
        BankAccount account = new BankAccount(100.0);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(150.0);
        });

        assertEquals("Invalid withdrawal amount", exception.getMessage());
    }

    @Test
    public void testInvalidDeposit() {
        BankAccount account = new BankAccount(100.0);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50.0);
        });

        assertEquals("Invalid deposit amount", exception.getMessage());
    }
}
