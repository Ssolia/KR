package cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaxiTest {
    private Taxi taxi;

    @BeforeEach
    public void setUp() {
        taxi = new Taxi("XYZ789", "Ford", "Yellow", 100, 10.0, 15000, 4);
    }

    @Test
    public void testGetPassengerCount() {
        assertEquals(4, taxi.getPassengerCount());
    }

    @Test
    public void testSetPassengerCount() {
        taxi.passenger_count = 5;
        assertEquals(5, taxi.getPassengerCount());
    }

    @Test
    public void testGetType() {
        assertEquals(CarTypes.TAXI, taxi.getType());
    }

    @Test
    public void testGetPlate() {
        assertEquals("XYZ789", taxi.getPlate());
    }

    @Test
    public void testSetPlate() {
        taxi.setPlate("LMN123");
        assertEquals("LMN123", taxi.getPlate());
    }

    @Test
    public void testGetMark() {
        assertEquals("Ford", taxi.getMark());
    }

    @Test
    public void testSetMark() {
        taxi.setMark("Toyota");
        assertEquals("Toyota", taxi.getMark());
    }

    @Test
    public void testGetColour() {
        assertEquals("Yellow", taxi.getColour());
    }

    @Test
    public void testSetColour() {
        taxi.setColour("Blue");
        assertEquals("Blue", taxi.getColour());
    }

    @Test
    public void testGetSpeed() {
        assertEquals(100, taxi.getSpeed());
    }

    @Test
    public void testSetSpeed() {
        taxi.setSpeed(120);
        assertEquals(120, taxi.getSpeed());
    }

    @Test
    public void testGetGas() {
        assertEquals(10.0, taxi.getGas());
    }

    @Test
    public void testSetGas() {
        taxi.setGas(15.0);
        assertEquals(15.0, taxi.getGas());
    }

    @Test
    public void testGetPrice() {
        assertEquals(15000, taxi.getPrice());
    }

    @Test
    public void testSetPrice() {
        taxi.setPrice(20000);
        assertEquals(20000, taxi.getPrice());
    }

    @Test
    public void testToString() {
        String expected = "Type: TAXI, Plate: XYZ789, Mark: Ford, Color: Yellow, Speed: 100, Gas: 10.0, Price: 15000, Passenger Count: 4";
        assertEquals(expected, taxi.toString());
    }

    @Test
    public void testShow() {
        taxi.Show();
        // Redirect System.out to test console output if needed
    }
}
