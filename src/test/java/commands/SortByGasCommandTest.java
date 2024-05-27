package commands;

import cars.TaxoPark;
import org.junit.jupiter.api.*;
import org.mockito.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SortByGasCommandTest {

    @Mock
    private TaxoPark taxoPark;

    private SortByGasCommand command;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        taxoPark = mock(TaxoPark.class);
        command = new SortByGasCommand(taxoPark);
    }

    @Test
    public void testExecute() {
        command.execute("");

        verify(taxoPark, times(1)).SortByGas();
    }

    @Test
    public void testGetCommandName() {
        assertEquals("sort", command.getCommandName());
    }
}
