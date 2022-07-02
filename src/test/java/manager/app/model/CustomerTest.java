package manager.app.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import manager.app.data.CustomerIdSequencer;

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
    void should_Return_Customer_AccountList() {
        int customerId = CustomerIdSequencer.nextCustomerId();
        String firstName = "Chris";
        String lastName = "Lucky";
        String email = "cl@email.com";

        List<BankAccount> expectedAccountList = new ArrayList<>();

        //Act
        Customer customer = new Customer(customerId, firstName, lastName, email);

        //Assert
        assertEquals(expectedAccountList, customer.getBankAccountList());
    }

}