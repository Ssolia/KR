package main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
    }

    @Test
    public void testCommandExecution_showCommand() {
        provideInput("show\nexit\n");

        Main.main(new String[]{});

        assertTrue(outContent.toString().contains("Bolt Taxi"));
        assertTrue(outContent.toString().contains("Nissan"));
        assertTrue(outContent.toString().contains("Driver: Mykola"));
    }

    @Test
    public void testCommandExecution_helpCommand() {
        provideInput("help\nexit\n");

        Main.main(new String[]{});

        assertTrue(outContent.toString().contains("create"));
        assertTrue(outContent.toString().contains("show"));
        assertTrue(outContent.toString().contains("add"));
        assertTrue(outContent.toString().contains("calculate"));
        assertTrue(outContent.toString().contains("sort"));
        assertTrue(outContent.toString().contains("find"));
    }

    @Test
    public void testCommandExecution_unknownCommand() {
        provideInput("unknown\nexit\n");

        Main.main(new String[]{});

        assertTrue(outContent.toString().contains("Невідома команда. Введіть 'help' для списку команд."));
    }

    private void provideInput(String data) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }
}
