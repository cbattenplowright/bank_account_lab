import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    public void createBankAccount() {
        bankAccount = new BankAccount("Callum", "Batten-Plowright", LocalDate.of(2000, 10, 15), 3562712, "Savings");
    }

//    Tests for getters and setters
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
        double expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canSetBalance() {
        bankAccount.setBalance(34567);
        double actual = bankAccount.getBalance();
        double expected = (double) 34567 / 100;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canGetAccountType() {
        String actual = bankAccount.getAccountType();
        String expected = "Savings";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canSetAccountType() {
        bankAccount.setAccountType("Current");
        String actual = bankAccount.getAccountType();
        String expected = "Current";
        assertThat(actual).isEqualTo(expected);
    }

//    Deposit test
    @Test
    public void canDeposit() {
        bankAccount.deposit(15000);
        double actual = bankAccount.getBalance();
        double expected = 150.00;
        assertThat(actual).isEqualTo(expected);
    }

//    Withdraw test

    @Test
    public void canWithdraw() {
        bankAccount.setBalance(12345);
        assertThat(bankAccount.withdraw(10000)).isEqualTo("Withdrawal successful you have 23.45 remaining in your account");
    }

//    Interest test
    @Test
    public void canPayInterestOnSavingsAccount() {
        bankAccount.setAccountType("Savings");
        bankAccount.setBalance(10000);
        bankAccount.payInterest();
        double actual = bankAccount.getBalance();
        double expected = 104.00;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canPayInterestOnCurrentAccount() {
        bankAccount.setAccountType("Current");
        bankAccount.setBalance(101);
        bankAccount.payInterest();
        double actual = bankAccount.getBalance();
        double expected = 101;
    }

    @Test
    public void withdrawalDeclined() {
        bankAccount.setBalance(10000);
        assertThat(bankAccount.withdraw(120000)).isEqualTo("You have insufficient funds to make this withdrawal");
    }


}
