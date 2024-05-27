package commands;

import cars.TaxoPark;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CreateGarageCommandTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Mock
    private TaxoPark taxoPark;

    private CreateGarageCommand command;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setOut(new PrintStream(outContent));
        taxoPark = mock(TaxoPark.class);
        command = new CreateGarageCommand(taxoPark);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testExecute() {
        String garageName = "NewGarage";
        command.execute(garageName);

        String expectedOutput = "Гараж '" + garageName + "' створено.\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testGetCommandName() {
        assertEquals("create", command.getCommandName());
    }
}
