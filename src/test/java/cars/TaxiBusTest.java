package cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaxiBusTest {
    private TaxiBus taxiBus;

    @BeforeEach
    public void setUp() {
        taxiBus = new TaxiBus("PQR321", "Volvo", "Blue", 80, 12.0, 25000, 50.5, 3000);
    }

    @Test
    public void testGetType() {
        assertEquals(CarTypes.TAXIBUS, taxiBus.getType());
    }

    @Test
    public void testGetPlate() {
        assertEquals("PQR321", taxiBus.getPlate());
    }

    @Test
    public void testSetPlate() {
        taxiBus.setPlate("RST456");
        assertEquals("RST456", taxiBus.getPlate());
    }

    @Test
    public void testGetMark() {
        assertEquals("Volvo", taxiBus.getMark());
    }

    @Test
    public void testSetMark() {
        taxiBus.setMark("Mercedes");
        assertEquals("Mercedes", taxiBus.getMark());
    }

    @Test
    public void testGetColour() {
        assertEquals("Blue", taxiBus.getColour());
    }

    @Test
    public void testSetColour() {
        taxiBus.setColour("Red");
        assertEquals("Red", taxiBus.getColour());
    }

    @Test
    public void testGetSpeed() {
        assertEquals(80, taxiBus.getSpeed());
    }

    @Test
    public void testSetSpeed() {
        taxiBus.setSpeed(100);
        assertEquals(100, taxiBus.getSpeed());
    }

    @Test
    public void testGetGas() {
        assertEquals(12.0, taxiBus.getGas());
    }

    @Test
    public void testSetGas() {
        taxiBus.setGas(15.0);
        assertEquals(15.0, taxiBus.getGas());
    }

    @Test
    public void testGetPrice() {
        assertEquals(25000, taxiBus.getPrice());
    }

    @Test
    public void testSetPrice() {
        taxiBus.setPrice(30000);
        assertEquals(30000, taxiBus.getPrice());
    }

    @Test
    public void testGetVolume() {
        assertEquals(50.5, taxiBus.getVolume());
    }

    @Test
    public void testSetVolume() {
        taxiBus.volume = 60.5;
        assertEquals(60.5, taxiBus.getVolume());
    }

    @Test
    public void testGetWeight() {
        assertEquals(3000, taxiBus.getWeight());
    }

    @Test
    public void testSetWeight() {
        taxiBus.weight = 3500;
        assertEquals(3500, taxiBus.getWeight());
    }

    @Test
    public void testToString() {
        String expected = "Type: TAXIBUS, Plate: PQR321, Mark: Volvo, Color: Blue, Speed: 80, Gas: 12.0, Price: 25000, Volume: 50.5, Weight: 3000.0";
        assertEquals(expected, taxiBus.toString());
    }

    @Test
    public void testShow() {
        taxiBus.Show();
        // Redirect System.out to test console output if needed
    }
}
