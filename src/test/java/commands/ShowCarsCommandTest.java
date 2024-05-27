package commands;

import cars.TaxoPark;
import org.junit.jupiter.api.*;
import org.mockito.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ShowCarsCommandTest {

    @Mock
    private TaxoPark taxoPark;

    private ShowCarsCommand command;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        taxoPark = mock(TaxoPark.class);
        command = new ShowCarsCommand(taxoPark);
    }

    @Test
    public void testExecute() {
        command.execute("");

        verify(taxoPark, times(1)).Show();
    }

    @Test
    public void testGetCommandName() {
        assertEquals("show", command.getCommandName());
    }
}
