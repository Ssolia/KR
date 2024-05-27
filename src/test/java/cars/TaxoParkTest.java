package cars;

import org.junit.jupiter.api.*;
import org.mockito.*;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TaxoParkTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    private TaxoPark taxoPark;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        taxoPark = new TaxoPark("TestTaxoPark");
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testGetTotalPrice() {
        int totalPrice = taxoPark.GetTotalPrice();
        assertEquals(1450000, totalPrice);
    }

    @Test
    public void testShow() {
        taxoPark.Show();
        String expectedOutput = "TestTaxoPark:\r\n" +
                "Type: TAXI, Plate: ВС 2054 АР, Mark: Nissan, Color: CYAN, Speed: 120, Gas: 15.0, Price: 500000, Passenger Count: 4\r\n" +
                "Type: ELITETAXI, Plate: ВС 2054 АР, Mark: Nissan, Color: RED, Speed: 260, Gas: 5.0, Price: 150000, Passenger Count: 2, Driver: Mykola\r\n" +
                "Type: TAXIBUS, Plate: ВС 2054 АР, Mark: Nissan, Color: WHITE, Speed: 100, Gas: 10.0, Price: 800000, Volume: 8.0, Weight: 7.0\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShowCarSetBySpeed() {
        taxoPark.ShowCarSetBySpeed(100, 200);
        String expectedOutput = "Speed diapason (100 - 200) :\r\n" +
                "Type: TAXI, Plate: ВС 2054 АР, Mark: Nissan, Color: CYAN, Speed: 120, Gas: 15.0, Price: 500000, Passenger Count: 4\r\n" +
                "Type: TAXIBUS, Plate: ВС 2054 АР, Mark: Nissan, Color: WHITE, Speed: 100, Gas: 10.0, Price: 800000, Volume: 8.0, Weight: 7.0\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testSortByGas() {
        taxoPark.SortByGas();
        String expectedOutput = "Sort by gas\r\n" +
                "TestTaxoPark:\r\n" +
                "Type: ELITETAXI, Plate: ВС 2054 АР, Mark: Nissan, Color: RED, Speed: 260, Gas: 5.0, Price: 150000, Passenger Count: 2, Driver: Mykola\r\n" +
                "Type: TAXIBUS, Plate: ВС 2054 АР, Mark: Nissan, Color: WHITE, Speed: 100, Gas: 10.0, Price: 800000, Volume: 8.0, Weight: 7.0\r\n" +
                "Type: TAXI, Plate: ВС 2054 АР, Mark: Nissan, Color: CYAN, Speed: 120, Gas: 15.0, Price: 500000, Passenger Count: 4\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testAdd() {
        taxoPark.Add("Plate123", "Toyota", "Blue", 150, 10, 300000, CarTypes.TAXI, 4, 0, 0);

        List<Car> garage = taxoPark.garage;
        assertEquals(4, garage.size());
        assertTrue(garage.get(3) instanceof Taxi);
    }

    @Test
    public void testSaveCarToDatabase() throws SQLException {
        TaxoPark spyTaxoPark = Mockito.spy(taxoPark);
        Taxi taxi = new Taxi("Plate789", "Ford", "Green", 170, 8, 280000, 4);

        doNothing().when(spyTaxoPark).saveCarToDatabase(any());

        spyTaxoPark.Add("Plate789", "Ford", "Green", 170, 8, 280000, CarTypes.TAXI, 4, 0, 0);

        verify(spyTaxoPark, times(1)).saveCarToDatabase(any());
    }

    @Test
    public void testSaveCarToDatabaseIntegration() throws SQLException {
        TaxoPark spyTaxoPark = Mockito.spy(taxoPark);
        Taxi taxi = new Taxi("Plate789", "Ford", "Green", 170, 8, 280000, 4);

        spyTaxoPark.Add("Plate789", "Ford", "Green", 170, 8, 280000, CarTypes.TAXI, 4, 0, 0);

        verify(spyTaxoPark, times(1)).saveCarToDatabase(any());
    }
}