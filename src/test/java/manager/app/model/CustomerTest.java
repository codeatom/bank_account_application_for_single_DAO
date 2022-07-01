package manager.app.model;

import manager.app.data.CustomerIdSequencer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    void should_Construct_A_Customer_Object_With_Expected_Fields() {
        //Arrange
        int customerId = CustomerIdSequencer.nextCustomerId();
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        //Act
        Customer customer = new Customer(customerId, firstName, lastName, email);

        //Assert
        assertAll(
                () -> assertEquals(customerId, customer.getId()),
                () -> assertEquals(firstName, customer.getFirstName()),
                () -> assertEquals(lastName, customer.getLastName()),
                () -> assertEquals(email, customer.getEmail())
        );

    }

    @Test
    void should_Return_Customer_Id() {
        //Arrange
        int customerId = CustomerIdSequencer.nextCustomerId();
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        //Act
        Customer customer = new Customer(customerId, firstName, lastName, email);

        //Assert
        assertEquals(customerId, customer.getId());
    }

    @Test
    void should_Return_Customer_FirstName() {
        int customerId = CustomerIdSequencer.nextCustomerId();
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        //Act
        Customer customer = new Customer(customerId, firstName, lastName, email);

        //Assert
        assertEquals(firstName, customer.getFirstName());
    }

    @Test
    void should_Set_Customer_FirstName() {
        int customerId = CustomerIdSequencer.nextCustomerId();
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        String expectedFirstName = "Norah";

        //Act
        Customer customer = new Customer(customerId, firstName, lastName, email);
        customer.setFirstName(expectedFirstName);

        //Assert
        assertEquals(expectedFirstName, customer.getFirstName());
    }

    @Test
    void should_Return_Customer_LastName() {
        int customerId = CustomerIdSequencer.nextCustomerId();
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        //Act
        Customer customer = new Customer(customerId, firstName, lastName, email);

        //Assert
        assertEquals(lastName, customer.getLastName());
    }

    @Test
    void should_Set_Customer_LastName() {
        int customerId = CustomerIdSequencer.nextCustomerId();
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        String expectedLastName = "Norah";

        //Act
        Customer customer = new Customer(customerId, firstName, lastName, email);
        customer.setLastName(expectedLastName);

        //Assert
        assertEquals(expectedLastName, customer.getLastName());
    }

    @Test
    void should_Return_Customer_Email() {
        int customerId = CustomerIdSequencer.nextCustomerId();
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        //Act
        Customer customer = new Customer(customerId, firstName, lastName, email);

        //Assert
        assertEquals(email, customer.getEmail());
    }

    @Test
    void should_Set_Customer_Email() {
        int customerId = CustomerIdSequencer.nextCustomerId();
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        String expectedEmail = "newEmail@email.com";

        //Act
        Customer customer = new Customer(customerId, firstName, lastName, email);
        customer.setEmail(expectedEmail);

        //Assert
        assertEquals(expectedEmail, customer.getEmail());
    }

    @Test
    void should_Return_Customer_AccountNumber() {
        int customerId = CustomerIdSequencer.nextCustomerId();
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";
        int accountNumber = 1;

        //Act
        Customer customer = new Customer(customerId, firstName, lastName, email);
        customer.setAccountNumber(accountNumber);

        //Assert
        assertEquals(accountNumber, customer.getAccountNumber());
    }

    @Test
    void should_Set_Customer_AccountNumber() {
        int customerId = CustomerIdSequencer.nextCustomerId();
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";
        int accountNumber = 1;

        int expectedAccNumber = 3;

        //Act
        Customer customer = new Customer(customerId, firstName, lastName, email);
        customer.setAccountNumber(expectedAccNumber);

        //Assert
        assertEquals(expectedAccNumber, customer.getAccountNumber());
    }

}