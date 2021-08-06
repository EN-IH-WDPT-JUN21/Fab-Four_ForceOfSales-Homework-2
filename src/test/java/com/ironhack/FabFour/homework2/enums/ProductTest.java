package com.ironhack.FabFour.homework2.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProductTest {

    @Test
    @DisplayName("Test: getProduct(). Return correct enum value as expected.")
    void Industry_getProduct_ReturnCorrectProductType() {
        assertEquals(Product.BOX, Product.getProduct("Box"));
        assertEquals(Product.HYBRID, Product.getProduct("hyBrid"));
        assertEquals(Product.FLATBED, Product.getProduct("flatbed"));
    }

    @Test
    @DisplayName("Test: getProduct(). Return null as invalid input provided.")
    void Industry_getProduct_ReturnNull() {
        assertNull(Product.getProduct("SEMI"));
    }
}
