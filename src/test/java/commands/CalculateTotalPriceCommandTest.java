package commands;

import cars.TaxoPark;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculateTotalPriceCommandTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Mock
    private TaxoPark taxoPark;

    private CalculateTotalPriceCommand command;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setOut(new PrintStream(outContent));
        taxoPark = mock(TaxoPark.class);
        command = new CalculateTotalPriceCommand(taxoPark);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testExecute() {
        when(taxoPark.GetTotalPrice()).thenReturn(1450000);

        command.execute("");

        assertEquals("Загальна вартість =  1450000\r\n", outContent.toString());
        verify(taxoPark, times(1)).GetTotalPrice();
    }

    @Test
    public void testGetCommandName() {
        assertEquals("calculate", command.getCommandName());
    }
}
