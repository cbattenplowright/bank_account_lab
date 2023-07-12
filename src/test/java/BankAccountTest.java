import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    public void createBankAccount() {
        bankAccount = new BankAccount("Callum", "Batten-Plowright", LocalDate.of(2000, 10, 15), 3562712, 123.45);
    }

    @Test
    public void canGetFirstName() {
        String actual = bankAccount.getFirstName();
        String expected = "Callum";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canSetFirstName() {
        bankAccount.setFirstName("Sid");
        String actual = bankAccount.getFirstName();
        String expected = "Sid";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canGetLastName() {
        String actual = bankAccount.getLastName();
        String expected = "Batten-Plowright";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canSetLastName() {
        bankAccount.setLastName("Smith");
        String actual = bankAccount.getLastName();
        String expected = "Smith";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canGetDateOfBirth() {
        LocalDate actual = bankAccount.getDateOfBirth();
        LocalDate expected = LocalDate.of(2000, 10, 15);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canSetDateOfBirth() {
        bankAccount.setDateOfBirth(LocalDate.of(1975, 1, 1));
        LocalDate actual = bankAccount.getDateOfBirth();
        LocalDate expected = LocalDate.of(1975, 1, 1);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canGetAccountNumber() {
        int actual = bankAccount.getAccountNumber();
        int expected = 3562712;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canSetAccountNumber() {
        bankAccount.setAccountNumber(1234567);
        int actual = bankAccount.getAccountNumber();
        int expected = 1234567;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canGetBalance() {
        double actual = bankAccount.getBalance();
        double expected = 123.45;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canSetBalance(){
        bankAccount.setBalance(345.67);
        double actual = bankAccount.getBalance();
        double expected = 345.67;
        assertThat(actual).isEqualTo(expected);
    }

}
