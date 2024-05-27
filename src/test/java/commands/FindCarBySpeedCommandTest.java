package commands;

import cars.TaxoPark;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class FindCarBySpeedCommandTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Mock
    private TaxoPark taxoPark;

    private FindCarBySpeedCommand command;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setOut(new PrintStream(outContent));
        taxoPark = mock(TaxoPark.class);
        command = new FindCarBySpeedCommand(taxoPark);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testExecute() {
        String input = "100 200";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        command.execute(input);

        String expectedOutput = "Введіть швидкість від: \r\n" +
                "Введіть швидкість до: \r\n";
        assertEquals(expectedOutput, outContent.toString());
        verify(taxoPark, times(1)).ShowCarSetBySpeed(100, 200);
    }

    @Test
    public void testGetCommandName() {
        assertEquals("find", command.getCommandName());
    }
}
