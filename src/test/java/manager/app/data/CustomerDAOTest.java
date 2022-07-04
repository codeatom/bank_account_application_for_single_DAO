package manager.app.data;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import manager.app.model.Customer;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerDAOTest {
    Customer customer1;
    Customer customer2;
    Customer customer3;

    @BeforeAll
    void setupBeforeAll(){
        customer1 = new Customer("Odi", "Sombathkamria", "odi@gmail.com");
        customer2 = new Customer("Nader", "Alhamwi", "nader@gmail.com");
        customer3 = new Customer("Christopher", "Svensson", "christopher@gmail.com");

        CustomerDAO.addCustomerToList(customer1);
        CustomerDAO.addCustomerToList(customer2);
        CustomerDAO.addCustomerToList(customer3);

        CustomerDAO.addEmailToList("A@email.com");
        CustomerDAO.addEmailToList("B@email.com");
        CustomerDAO.addEmailToList("C@email.com");
        CustomerDAO.addEmailToList("D@email.com");
        CustomerDAO.addEmailToList("nonUnique@email.com");
    }

    @BeforeEach
    void setupBeforeEach(){
        AccountNumberSequencer.resetAccountNumber();
        CustomerIdSequencer.resetCustomerId();
    }

    @Test
    void should_Create_A_CreateCustomer() {
        //Arrange
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        //Act
        Customer customer = CustomerDAO.createCustomer(firstName, lastName, email);

        //Assert
        assertEquals(firstName, customer.getFirstName());
        assertEquals(lastName, customer.getLastName());
        assertEquals(email, customer.getEmail());
    }

    @Test
    void should_Return_True_When_Customer_Email_Is_Unique() {
        //Arrange

        //Act
        boolean emailIsValid = CustomerDAO.emailIsUnique("uniqueEmail@email.com");

        //Assert
        assertTrue(emailIsValid);
    }

    @Test
    void should_Return_False_When_Customer_Email_Is_Not_Unique() {
        //Arrange

        //Act
        boolean emailIsValid = CustomerDAO.emailIsUnique("nonUnique@email.com");

        //Assert
        assertFalse(emailIsValid);
    }

    @Test
    void should_Return_A_Customer_With_A_Given_Id() {
        //Arrange

        //Act
        Customer expectedCustomer = CustomerDAO.searchById(customer3.getId());

        // Assert
        assertEquals(customer3, expectedCustomer);
    }

    @Test
    void should_Return_Null_When_Id_Is_Not_Valid() {
        //Arrange

        //Act
        Customer expectedCustomer = CustomerDAO.searchById(100);

        // Assert
        assertNull(expectedCustomer);
    }

    @Test
    void should_Remove_A_Customer_With_A_Given_Id() {
        //Arrange

        //Act
        boolean customerRemoved = CustomerDAO.removeCustomerFromList(customer2.getId());

        // Assert
        assertTrue(customerRemoved);
    }

    @Test
    void should_Not_Remove_A_Customer_When_Id_Is_Invalid() {
        //Arrange

        //Act
        boolean customerRemoved = CustomerDAO.removeCustomerFromList(100);

        // Assert
        assertFalse(customerRemoved);
    }
}