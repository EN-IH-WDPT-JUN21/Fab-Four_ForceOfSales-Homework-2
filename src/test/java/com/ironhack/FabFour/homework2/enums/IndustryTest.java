package com.ironhack.FabFour.homework2.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IndustryTest {

    @Test
    void enumExists_CorrectValues() {
        assertEquals(Industry.OTHER, Industry.valueOf("OTHER"));
    }
}
