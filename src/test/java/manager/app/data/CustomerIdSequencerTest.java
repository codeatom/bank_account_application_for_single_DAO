package manager.app.data;

import manager.app.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerIdSequencerTest {

    @Test
    void Should_Return_Sequential_int() {
        //Arrange
        int id = 0;
        int expectedId = 4;

        //Act
        id = CustomerIdSequencer.nextCustomerId();
        id = CustomerIdSequencer.nextCustomerId();
        id = CustomerIdSequencer.nextCustomerId();
        id = CustomerIdSequencer.nextCustomerId();

        //Assert
        assertEquals(expectedId, id);
    }

    @Test
    void should_Reset_Id_To_Zero() {
        //Arrange
        int id = 0;
        int expectedId = 0;

        //Act
        id = CustomerIdSequencer.nextCustomerId();
        id = CustomerIdSequencer.nextCustomerId();
        id = CustomerIdSequencer.nextCustomerId();
        id = CustomerIdSequencer.nextCustomerId();

        id = CustomerIdSequencer.resetId();

        //Assert
        assertEquals(expectedId, id);
    }
}