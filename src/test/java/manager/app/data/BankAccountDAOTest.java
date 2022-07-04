package manager.app.data;

import manager.app.model.BankAccount;
import manager.app.model.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankAccountDAOTest {
    BankAccount bankAccount1;
    BankAccount bankAccount2;
    BankAccount bankAccount3;

    @BeforeAll
    void setupBeforeAll(){
        bankAccount1 = new BankAccount(1, 10);
        bankAccount2 = new BankAccount(2, 20);
        bankAccount3 = new BankAccount(3, 30);

        BankAccountDAO.addBankAccountToList(bankAccount1);
        BankAccountDAO.addBankAccountToList(bankAccount2);
        BankAccountDAO.addBankAccountToList(bankAccount3);
    }

    @BeforeEach
    void setupBeforeEach(){
        AccountNumberSequencer.resetAccountNumber();
        CustomerIdSequencer.resetCustomerId();
    }

    @Test
    void should_Create_A_Bank_Account() {
        //Arrange
        double accountBalance = 30;

        //Act
        Customer customer = new Customer("Christopher", "Lucky", "cl@email.com");
        BankAccount expectedAccount = BankAccountDAO.createBankAccount(customer, accountBalance);

        int expectedAccountNumber = AccountNumberSequencer.readAccountNumber();
        int expectedCustomerId = CustomerIdSequencer.readCustomerId();

        //Assert
        assertEquals(expectedAccountNumber, expectedAccount.getAccountNumber());
        assertEquals(expectedCustomerId, expectedAccount.getCustomerId());
        assertEquals(accountBalance, expectedAccount.getBalance());
    }

    @Test
    void should_Return_A_Bank_Account_With_A_Given_Id() {
        //Arrange

        //Act
        BankAccount expectedBankAccount = BankAccountDAO.searchByAccountNumber(bankAccount2.getAccountNumber());

        // Assert
        assertEquals(bankAccount2, expectedBankAccount);
    }

    @Test
    void should_Return_Null_When_Account_Number_Is_Not_Valid() {
        //Arrange

        //Act
        BankAccount expectedBankAccount = BankAccountDAO.searchByAccountNumber(5);

        // Assert
        assertNull(expectedBankAccount);
    }

    @Test
    void should_Remove_A_Bank_Account_With_A_Given_Account_Number() {
        //Arrange

        //Act
        boolean accountRemoved = BankAccountDAO.removeAccountFromList(bankAccount3.getAccountNumber());

        // Assert
        assertTrue(accountRemoved);
    }

    @Test
    void should_Not_Remove_A_Bank_Account_When_A_Given_Account_Number_Is_Invalid() {
        //Arrange

        //Act
        boolean accountRemoved = BankAccountDAO.removeAccountFromList(8);

        // Assert
        assertFalse(accountRemoved);
    }

    @Test
    void should_Remove_A_Bank_Account_From_Customer_AccountList_And_CustomerDAO_AccountList() {
        ///Arrange
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        //Act
        Customer customer = new Customer(firstName, lastName, email);

        customer.addAccountToList(bankAccount1);
        BankAccountDAO.addBankAccountToList(bankAccount1);

        boolean accountRemoved = BankAccountDAO.closeAccount(customer, bankAccount1.getAccountNumber());

        // Assert
        assertTrue(accountRemoved);
    }
}