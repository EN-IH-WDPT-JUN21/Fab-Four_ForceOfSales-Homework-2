package com.ironhack.FabFour.homework2.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StatusTest {

    @Test
    @DisplayName("Test: getStatus(). Return correct enum value as expected.")
    void Status_getStatus_ReturnCorrectStatusType() {
        assertEquals(Status.OPEN, Status.getStatus("OPEN"));
        assertEquals(Status.CLOSED_LOST, Status.getStatus("closed-lost"));
        assertEquals(Status.CLOSED_WON, Status.getStatus("Closed-Won"));
    }

    @Test
    @DisplayName("Test: getStatus(). Return null as invalid input provided.")
    void Status_getStatus_ReturnNull() {
        assertNull(Status.getStatus("anoTher"));
    }
}
