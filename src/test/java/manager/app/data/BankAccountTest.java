package manager.app.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import manager.app.model.BankAccount;


class BankAccountTest {

    @BeforeEach
    void setup(){
        AccountNumberSequencer.resetNumber();
    }

    @Test
    void should_Return_Bank_AccountNumber() {
        //Arrange
        int accNumber= AccountNumberSequencer.nextAccountNumber();
        int customerId = 1;
        double balance = 10.0;

        //Act
        BankAccount bankAccount = new BankAccount(accNumber, customerId, balance);

        //Assert
        assertEquals(accNumber, bankAccount.getAccountNumber());
    }

    @Test
    void should_Return_Account_Balance() {
        //Arrange
        int accNumber= AccountNumberSequencer.nextAccountNumber();
        int customerId = 1;
        double balance = 10.0;

        //Act
        BankAccount bankAccount = new BankAccount(accNumber, customerId, balance);

        //Assert
        assertEquals(balance, bankAccount.getBalance());
    }

    @Test
    void should_Return_Customer_Id() {
        //Arrange
        int accNumber= AccountNumberSequencer.nextAccountNumber();
        int customerId = 1;
        double balance = 10.0;

        //Act
        BankAccount bankAccount = new BankAccount(accNumber, customerId, balance);

        //Assert
        assertEquals(customerId, bankAccount.getCustomerId());
    }

    @Test
    void should_Add_Funds_To_Account_Balance() {
        //Arrange
        int accNumber= AccountNumberSequencer.nextAccountNumber();
        int customerId = 1;
        double balance = 10.0;

        //Act
        BankAccount bankAccount = new BankAccount(accNumber, customerId, balance);

        balance = bankAccount.depositFund(20.0);

        //Assert
        assertEquals(balance, bankAccount.getBalance());
    }

    @Test
    void should_Withdraw_Funds_When_Balance_Is_Enough() {
        //Arrange
        int accNumber= AccountNumberSequencer.nextAccountNumber();
        int customerId = 1;
        double balance = 100.0;

        //Act
        BankAccount bankAccount = new BankAccount(accNumber, customerId, balance);

        balance = bankAccount.withdraw(50);

        //Assert
        assertEquals(balance, bankAccount.getBalance());
    }

    @Test
    void should_Not_Withdraw_Funds_When_Balance_Is_Not_Enough() {
        //Arrange
        int accNumber= AccountNumberSequencer.nextAccountNumber();
        int customerId = 1;
        double balance = 10.0;

        //Act
        BankAccount bankAccount = new BankAccount(accNumber, customerId, balance);

        Executable executable = () -> bankAccount.withdraw(50);

        //Assert
        assertThrows(IllegalArgumentException.class, executable);
    }
}