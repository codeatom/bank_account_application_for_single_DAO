package manager.app.data;

import manager.app.model.BankAccount;
import manager.app.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountDAOTest {

    @BeforeEach
    void setup(){
        AccountNumberSequencer.resetAccountNumber();
        CustomerIdSequencer.resetCustomerId();
        CustomerDAO.resetCustomerList();
        CustomerDAO.resetCustomerEmailList();
        BankAccountDAO.resetBankAccountList();
    }

    @Test
    void should_Create_A_Bank_Account() {
        //Arrange
        double balance = 30;

        //Act
        Customer customer = new Customer("Christopher", "Lucky", "cl@email.com");
        BankAccountDAO.createBankAccount(customer, balance);

        BankAccount expectedBankAccount = BankAccountDAO.getBankAccountList().get(0);
        int expectedAccountNumber = AccountNumberSequencer.readAccountNumber();
        int expectedCustomerId = CustomerIdSequencer.readCustomerId();

        //Assert
        assertEquals(expectedAccountNumber, expectedBankAccount.getAccountNumber());
        assertEquals(expectedCustomerId, expectedBankAccount.getCustomerId());
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

        BankAccount expectedBankAccount = BankAccountDAO.searchByAccountNumber(bankAccount2.getAccountNumber());

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

        BankAccount expectedBankAccount = BankAccountDAO.searchByAccountNumber(5);

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

        boolean accountRemoved = BankAccountDAO.removeAccountFromList(bankAccount3.getAccountNumber());

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

        BankAccount bankAccount = new BankAccount(1, 10);


        //Act
        Customer customer = new Customer(firstName, lastName, email);

        customer.addAccountToList(bankAccount);
        BankAccountDAO.addBankAccountToList(bankAccount);

        boolean accountRemoved = BankAccountDAO.closeAccount(customer, bankAccount.getAccountNumber());

        // Assert
        assertTrue(accountRemoved);
    }
}