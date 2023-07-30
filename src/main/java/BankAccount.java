import java.time.LocalDate;
import java.util.Objects;

public class BankAccount {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int accountNumber;
    private String accountType;
    private int balance;
    private int overdraft;

    public BankAccount(String firstName, String lastName, LocalDate dateOfBirth, int accountNumber, String accountType) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 0;
        this.overdraft = -10000;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return (double) this.balance / 100;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public String withdraw(double amount) {
        if (amount <= this.balance && this.balance >= this.overdraft) {
            this.balance -= amount;
            return "Withdrawal successful you have " + getBalance() + " remaining in your account";
        } else return "You have insufficient funds to make this withdrawal";
    }

    public void payInterest(){
        if (Objects.equals(accountType, "Savings")) {
            this.balance *= 1.04;
        }
        if (Objects.equals(accountType, "Current")) {
            this.balance *= 1.01;
        }
    }
}
