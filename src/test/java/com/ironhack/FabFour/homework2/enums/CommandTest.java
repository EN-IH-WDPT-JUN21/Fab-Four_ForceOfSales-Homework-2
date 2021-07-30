package com.ironhack.FabFour.homework2.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void Command_getCommandType_test() {

        assertEquals(Command.getCommandType("NEW LEAD"),Command.NEW_LEAD);
        assertEquals(Command.getCommandType("CONVERT"),Command.CONVERT);
        assertEquals(Command.getCommandType("CLOSE-LOST"),Command.CLOSE_LOST);
        assertEquals(Command.getCommandType("CLOSE-WON"),Command.CLOSE_WON);
        assertEquals(Command.getCommandType("SHOW LEADS"),Command.SHOW_LEADS);
        assertEquals(Command.getCommandType("HELP"),Command.HELP);
        assertEquals(Command.getCommandType("LOOKUP LEAD"),Command.LOOKUP_LEAD);
        assertEquals(Command.getCommandType("NONE"),Command.NONE);

    }
}