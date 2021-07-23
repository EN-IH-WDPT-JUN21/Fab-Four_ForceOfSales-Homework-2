package com.ironhack.FabFour.homework2.common;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandHandlerTest {

    @Test
     public void handleCommand_getProperCommand() {
        //TODO
    }

    @Test
    void getIdFromInput_test() {
        assertEquals(0, CommandHandler.getIdFromInput("test test"));
        assertEquals(12, CommandHandler.getIdFromInput("test 12"));
        assertEquals(133, CommandHandler.getIdFromInput("test 133         "));
        assertEquals(0, CommandHandler.getIdFromInput("         133 /        "));
    }
}
