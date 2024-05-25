package cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("ABC123", "Toyota", "Red", 120, 15.5, 20000);
    }

    @Test
    public void testGetType() {
        assertEquals(CarTypes.TAXI, car.getType());
    }

    @Test
    public void testSetType() {
        car.setType(CarTypes.TAXI);
        assertEquals(CarTypes.TAXI, car.getType());
    }

    @Test
    public void testGetPlate() {
        assertEquals("ABC123", car.getPlate());
    }

    @Test
    public void testSetPlate() {
        car.setPlate("XYZ789");
        assertEquals("XYZ789", car.getPlate());
    }

    @Test
    public void testGetMark() {
        assertEquals("Toyota", car.getMark());
    }

    @Test
    public void testSetMark() {
        car.setMark("Honda");
        assertEquals("Honda", car.getMark());
    }

    @Test
    public void testGetColour() {
        assertEquals("Red", car.getColour());
    }

    @Test
    public void testSetColour() {
        car.setColour("Blue");
        assertEquals("Blue", car.getColour());
    }

    @Test
    public void testGetSpeed() {
        assertEquals(120, car.getSpeed());
    }

    @Test
    public void testSetSpeed() {
        car.setSpeed(150);
        assertEquals(150, car.getSpeed());
    }

    @Test
    public void testGetGas() {
        assertEquals(15.5, car.getGas());
    }

    @Test
    public void testSetGas() {
        car.setGas(20.0);
        assertEquals(20.0, car.getGas());
    }

    @Test
    public void testGetPrice() {
        assertEquals(20000, car.getPrice());
    }

    @Test
    public void testSetPrice() {
        car.setPrice(25000);
        assertEquals(25000, car.getPrice());
    }

    @Test
    public void testToString() {
        String expected = "Type: TAXI, Plate: ABC123, Mark: Toyota, Color: Red, Speed: 120, Gas: 15.5, Price: 20000";
        assertEquals(expected, car.toString());
    }

    @Test
    public void testShow() {
        car.Show();
        // Redirect System.out to test console output if needed
    }
}