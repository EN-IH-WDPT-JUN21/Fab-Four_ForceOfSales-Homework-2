package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.enums.Industry;
import com.ironhack.FabFour.homework2.enums.Product;
import org.junit.jupiter.api.*;

import static com.ironhack.FabFour.homework2.common.EnumHandler.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnumHandlerTest {

    @Test
    @DisplayName("Test: getRequiredProduct(). Return product as expected.")
    public void EnumHandler_getRequiredProduct_correctProductReturned() {
        assertEquals(Product.BOX, getRequiredProduct("box"));
        assertEquals(Product.HYBRID, getRequiredProduct("hYBRid"));
        assertEquals(Product.FLATBED, getRequiredProduct("Flatbed"));
    }

    @Test
    @DisplayName("Test: getRequiredProduct(). Do not return product, as incorrect input provided.")
    public void EnumHandler_getRequiredProduct_nullReturned()  {
        assertEquals(null, getRequiredProduct("Pepsi"));
        assertEquals(null, getRequiredProduct(""));
    }

    @Test
    @DisplayName("Test: getRequiredIndustry(). Return industry as expected.")
    public void EnumHandler_getRequiredIndustry_correctIndustryReturned() {
        assertEquals(Industry.ECOMMERCE, getRequiredIndustry("ecommerce"));
        assertEquals(Industry.MANUFACTURING, getRequiredIndustry("MANufactUring"));
        assertEquals(Industry.MEDICAL, getRequiredIndustry("Medical"));
        assertEquals(Industry.OTHER, getRequiredIndustry("oTHER"));
        assertEquals(Industry.PRODUCE, getRequiredIndustry("PRODUCE"));
    }

    @Test
    @DisplayName("Test: getRequiredIndustry(). Do not return industry, as incorrect input provided.")
    public void EnumHandler_getRequiredIndustry_nullReturned() {
        assertEquals(null, getRequiredIndustry("cola"));
        assertEquals(null, getRequiredIndustry(""));
    }
}
