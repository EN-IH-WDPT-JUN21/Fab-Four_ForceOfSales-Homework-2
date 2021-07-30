package com.ironhack.FabFour.homework2.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusTest {

    @Test
    void enumExists_CorrectValues() {
        assertEquals(Status.OPEN, Status.valueOf("OPEN"));
    }
}
