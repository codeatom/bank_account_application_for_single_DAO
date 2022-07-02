package manager.app.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import manager.app.model.Customer;

class CustomerDAOTest {

    @BeforeEach
    void setup(){
        AccountNumberSequencer.resetNumber();
        CustomerIdSequencer.resetId();
        CustomerDAO.resetCustomerList();
        CustomerDAO.resetcustomerEmailList();
    }

    @Test
    void should_Create_A_CreateCustomer() {
        //Arrange
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        //Act
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.createCustomer(firstName, lastName, email);

        Customer expectedCustumer = CustomerDAO.getCustomerList().get(0);

        //Assert
        assertEquals(email, expectedCustumer.getEmail());
        assertEquals(lastName, expectedCustumer.getLastName());
        assertEquals(firstName, expectedCustumer.getFirstName());
    }

    @Test
    void should_Return_True_When_Customer_Email_Is_Unique() {
        //Arrange

        //Act
        CustomerDAO.addEmailToList("A@email.com");
        CustomerDAO.addEmailToList("B@email.com");
        CustomerDAO.addEmailToList("C@email.com");
        CustomerDAO.addEmailToList("D@email.com");
        CustomerDAO.addEmailToList("E@email.com");

        CustomerDAO customerDAO = new CustomerDAO();

        boolean emailIsValid = customerDAO.emailIsUnique("uniqueEmail@email.com");

        //Assert
        assertTrue(emailIsValid);
    }

    @Test
    void should_Return_False_When_Customer_Email_Is_Not_Unique() {
        //Arrange

        //Act
        CustomerDAO.addEmailToList("A@email.com");
        CustomerDAO.addEmailToList("B@email.com");
        CustomerDAO.addEmailToList("C@email.com");
        CustomerDAO.addEmailToList("D@email.com");
        CustomerDAO.addEmailToList("nonUnique@email.com");

        CustomerDAO customerDAO = new CustomerDAO();
        boolean emailIsValid = customerDAO.emailIsUnique("nonUnique@email.com");

        //Assert
        assertFalse(emailIsValid);
    }

    @Test
    void should_Return_A_Customer_With_A_Given_Id() {
        //Arrange
        Customer customer1 = new Customer("Odi", "Sombathkamria", "odi@gmail.com");
        Customer customer2 = new Customer("Nader", "Alhamwi", "nader@gmail.com");
        Customer customer3 = new Customer("Christopher", "Svensson", "christopher@gmail.com");

        //Act
        CustomerDAO.addCustomerToList(customer1);
        CustomerDAO.addCustomerToList(customer2);
        CustomerDAO.addCustomerToList(customer3);

        CustomerDAO customerDAO = new CustomerDAO();
        Customer expectedCustomer = customerDAO.searchById(customer3.getId());

        // Assert
        assertEquals(customer3, expectedCustomer);
    }

    @Test
    void should_Return_Null_When_Id_Is_Not_Valid() {
        //Arrange
        Customer customer1 = new Customer("Odi", "Sombathkamria", "odi@gmail.com");
        Customer customer2 = new Customer("Nader", "Alhamwi", "nader@gmail.com");
        Customer customer3 = new Customer("Christopher", "Svensson", "christopher@gmail.com");

        //Act
        CustomerDAO.addCustomerToList(customer1);
        CustomerDAO.addCustomerToList(customer2);
        CustomerDAO.addCustomerToList(customer3);

        CustomerDAO customerDAO = new CustomerDAO();
        Customer expectedCustomer = customerDAO.searchById(100);

        // Assert
        assertNull(expectedCustomer);
    }

    @Test
    void should_Remove_A_Customer_With_A_Given_Id() {
        //Arrange
        Customer customer1 = new Customer("Odi", "Sombathkamria", "odi@gmail.com");
        Customer customer2 = new Customer("Nader", "Alhamwi", "nader@gmail.com");
        Customer customer3 = new Customer("Christopher", "Svensson", "christopher@gmail.com");

        //Act
        CustomerDAO.addCustomerToList(customer1);
        CustomerDAO.addCustomerToList(customer2);
        CustomerDAO.addCustomerToList(customer3);

        CustomerDAO customerDAO = new CustomerDAO();
        boolean custumerRemodved = customerDAO.customerIsRemoved(customer2.getId());

        // Assert
        assertTrue(custumerRemodved);
    }

    @Test
    void should_Not_Remove_A_Customer_When_Id_Is_Invalid() {
        //Arrange
        Customer customer1 = new Customer("Odi", "Sombathkamria", "odi@gmail.com");
        Customer customer2 = new Customer("Nader", "Alhamwi", "nader@gmail.com");
        Customer customer3 = new Customer("Christopher", "Svensson", "christopher@gmail.com");

        //Act
        CustomerDAO.addCustomerToList(customer1);
        CustomerDAO.addCustomerToList(customer2);
        CustomerDAO.addCustomerToList(customer3);

        CustomerDAO customerDAO = new CustomerDAO();
        boolean custumerRemodved = customerDAO.customerIsRemoved(100);

        // Assert
        assertFalse(custumerRemodved);
    }
}