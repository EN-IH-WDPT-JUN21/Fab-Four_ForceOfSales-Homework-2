package com.ironhack.FabFour.homework2.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IndustryTest {

    @Test
    @DisplayName("Test: getIndustry(). Return correct enum value as expected.")
    void Industry_getIndustry_ReturnCorrectIndustryType() {
        assertEquals(Industry.OTHER, Industry.getIndustry("OTHER"));
        assertEquals(Industry.ECOMMERCE, Industry.getIndustry("ECOMMErcE"));
        assertEquals(Industry.MEDICAL, Industry.getIndustry("medical"));
        assertEquals(Industry.MANUFACTURING, Industry.getIndustry("Manufacturing"));
        assertEquals(Industry.PRODUCE, Industry.getIndustry("PRODUCE"));
    }

    @Test
    @DisplayName("Test: getIndustry(). Return null as invalid input provided.")
    void Industry_getIndustry_ReturnNull() {
        assertNull(Industry.getIndustry("AGRICULTURE"));
    }
}
