package cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EliteTaxiTest {
    private EliteTaxi eliteTaxi;

    @BeforeEach
    public void setUp() {
        eliteTaxi = new EliteTaxi("DEF456", "Mercedes", "Black", 180, 20.0, 50000, 4);
    }

    @Test
    public void testGetType() {
        assertEquals(CarTypes.ELITETAXI, eliteTaxi.getType());
    }

    @Test
    public void testGetPlate() {
        assertEquals("DEF456", eliteTaxi.getPlate());
    }

    @Test
    public void testSetPlate() {
        eliteTaxi.setPlate("GHI789");
        assertEquals("GHI789", eliteTaxi.getPlate());
    }

    @Test
    public void testGetMark() {
        assertEquals("Mercedes", eliteTaxi.getMark());
    }

    @Test
    public void testSetMark() {
        eliteTaxi.setMark("BMW");
        assertEquals("BMW", eliteTaxi.getMark());
    }

    @Test
    public void testGetColour() {
        assertEquals("Black", eliteTaxi.getColour());
    }

    @Test
    public void testSetColour() {
        eliteTaxi.setColour("White");
        assertEquals("White", eliteTaxi.getColour());
    }

    @Test
    public void testGetSpeed() {
        assertEquals(180, eliteTaxi.getSpeed());
    }

    @Test
    public void testSetSpeed() {
        eliteTaxi.setSpeed(200);
        assertEquals(200, eliteTaxi.getSpeed());
    }

    @Test
    public void testGetGas() {
        assertEquals(20.0, eliteTaxi.getGas());
    }

    @Test
    public void testSetGas() {
        eliteTaxi.setGas(25.0);
        assertEquals(25.0, eliteTaxi.getGas());
    }

    @Test
    public void testGetPrice() {
        assertEquals(50000, eliteTaxi.getPrice());
    }

    @Test
    public void testSetPrice() {
        eliteTaxi.setPrice(55000);
        assertEquals(55000, eliteTaxi.getPrice());
    }

    @Test
    public void testToString() {
        String expected = "Type: ELITETAXI, Plate: DEF456, Mark: Mercedes, Color: Black, Speed: 180, Gas: 20.0, Price: 50000, Passenger Count: 4, Driver: Mykola";
        assertEquals(expected, eliteTaxi.toString());
    }

    @Test
    public void testShow() {
        eliteTaxi.Show();
        // Redirect System.out to test console output if needed
    }
}
