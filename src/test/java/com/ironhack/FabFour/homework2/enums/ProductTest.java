package com.ironhack.FabFour.homework2.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    void enumExists_CorrectValues() {
        assertEquals(Product.BOX, Product.valueOf("BOX"));
    }
}
