package com.ironhack.FabFour.homework2.common;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static com.ironhack.FabFour.homework2.common.StartApp.startApp;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartAppTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("Test: startApp(). Quit method runs as expected.")
    public void StartApp_StartApp_QuitMethodRuns() {
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream("quit".getBytes()));
        startApp();
        System.setIn(savedStandardInputStream);
        String message = "______                                           __      _____           _              \n" +
                " |  ____|                                         / _|    / ____|         | |             \n" +
                " | |__      ___    _ __    ___    ___      ___   | |_    | (___     __ _  | |   ___   ___ \n" +
                " |  __|    / _ \\  | '__|  / __|  / _ \\    / _ \\  |  _|    \\___ \\   / _` | | |  / _ \\ / __|\n" +
                " | |      | (_) | | |    | (__  |  __/   | (_) | | |      ____) | | (_| | | | |  __/ \\__ \\\n" +
                " |_|       \\___/  |_|     \\___|  \\___|    \\___/  |_|     |_____/   \\__,_| |_|  \\___| |___/\n" +
                "                                                                                          " + System.getProperty("line.separator")
                + "Welcome to the best CRM!" + System.getProperty("line.separator") + "If you don't know what are you doing here just type: help"
                + System.getProperty("line.separator") + ">>> " +
                 "  ______                                           __      _____           _              \n" +
                " |  ____|                                         / _|    / ____|         | |             \n" +
                " | |__      ___    _ __    ___    ___      ___   | |_    | (___     __ _  | |   ___   ___ \n" +
                " |  __|    / _ \\  | '__|  / __|  / _ \\    / _ \\  |  _|    \\___ \\   / _` | | |  / _ \\ / __|\n" +
                " | |      | (_) | | |    | (__  |  __/   | (_) | | |      ____) | | (_| | | | |  __/ \\__ \\\n" +
                " |_|       \\___/  |_|     \\___|  \\___|    \\___/  |_|     |_____/   \\__,_| |_|  \\___| |___/\n" +
                "                                                                                          " + System.getProperty("line.separator")
                + "Thank you for using our CRM! :)\n\nFab Four Team";
        assertEquals(message, outputStreamCaptor.toString().trim());
    }
}
