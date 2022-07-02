package manager.app.data;

import manager.app.model.BankAccount;
import manager.app.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountDAOTest {

    @BeforeEach
    void setup(){
        AccountNumberSequencer.resetNumber();
        CustomerIdSequencer.resetId();
        CustomerDAO.resetCustomerList();
        CustomerDAO.resetcustomerEmailList();
        BankAccountDAO.resetBankAccountList();
    }

    @Test
    void should_Create_A_CreateCustomer() {
        //Arrange
        int customerId = 0;
        double balance = 1;

        //Act
        BankAccountDAO bankAccountDAO = new BankAccountDAO();
        bankAccountDAO.createBankAccount(customerId, balance);

        int accountNumber = AccountNumberSequencer.readAccountNumber();
        BankAccount expectedBankAccount = BankAccountDAO.getbankAccountList().get(0);

        //Assert
        assertEquals(accountNumber, expectedBankAccount.getAccountNumber());
        assertEquals(customerId, expectedBankAccount.getCustomerId());
        assertEquals(balance, expectedBankAccount.getBalance());
    }

    @Test
    void should_Return_A_Bank_Account_With_A_Given_Id() {
        //Arrange
        BankAccount bankAccount1 = new BankAccount(1, 10);
        BankAccount bankAccount2 = new BankAccount(2, 20);
        BankAccount bankAccount3 = new BankAccount(3, 30);

        //Act
        BankAccountDAO.addBankAccountToList(bankAccount1);
        BankAccountDAO.addBankAccountToList(bankAccount2);
        BankAccountDAO.addBankAccountToList(bankAccount3);

        BankAccountDAO bankAccountDAO = new BankAccountDAO();
        BankAccount expectedBankAccount = bankAccountDAO.searchByAccountNumber(bankAccount2.getAccountNumber());

        // Assert
        assertEquals(bankAccount2, expectedBankAccount);
    }

    @Test
    void should_Return_Null_When_Account_Number_Is_Not_Valid() {
        ///Arrange
        BankAccount bankAccount1 = new BankAccount(1, 10);
        BankAccount bankAccount2 = new BankAccount(2, 20);
        BankAccount bankAccount3 = new BankAccount(3, 30);

        //Act
        BankAccountDAO.addBankAccountToList(bankAccount1);
        BankAccountDAO.addBankAccountToList(bankAccount2);
        BankAccountDAO.addBankAccountToList(bankAccount3);

        BankAccountDAO bankAccountDAO = new BankAccountDAO();
        BankAccount expectedBankAccount = bankAccountDAO.searchByAccountNumber(5);

        // Assert
        assertNull(expectedBankAccount);
    }

    @Test
    void should_Remove_A_Bank_Account_With_A_Given_Account_Number() {
        ///Arrange
        BankAccount bankAccount1 = new BankAccount(1, 10);
        BankAccount bankAccount2 = new BankAccount(2, 20);
        BankAccount bankAccount3 = new BankAccount(3, 30);

        //Act
        BankAccountDAO.addBankAccountToList(bankAccount1);
        BankAccountDAO.addBankAccountToList(bankAccount2);
        BankAccountDAO.addBankAccountToList(bankAccount3);

        BankAccountDAO bankAccountDAO = new BankAccountDAO();
        boolean accountRemoved = bankAccountDAO.bankAccountIsRemoved(bankAccount3.getAccountNumber());

        // Assert
        assertTrue(accountRemoved);
    }

    @Test
    void should_Not_Remove_A_Bank_Account_When_A_Given_Account_Number_Is_Invalid() {
        ///Arrange
        BankAccount bankAccount1 = new BankAccount(1, 10);
        BankAccount bankAccount2 = new BankAccount(2, 20);
        BankAccount bankAccount3 = new BankAccount(3, 30);

        //Act
        BankAccountDAO.addBankAccountToList(bankAccount1);
        BankAccountDAO.addBankAccountToList(bankAccount2);
        BankAccountDAO.addBankAccountToList(bankAccount3);

        BankAccountDAO bankAccountDAO = new BankAccountDAO();
        boolean accountRemoved = bankAccountDAO.bankAccountIsRemoved(8);

        // Assert
        assertFalse(accountRemoved);
    }
}