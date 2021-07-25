package com.ironhack.FabFour.homework2.model;

import com.ironhack.FabFour.homework2.enums.Product;
import com.ironhack.FabFour.homework2.enums.Status;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.Scanner;

public class OpportunityTest {
    static Contact contact;
    static Opportunity opportunity;
    Opportunity opportunity1;
    static Contact contact1;
    static InputStream standardIn;

    @BeforeAll
    public static void setUp() {
        contact = new Contact("Mary Jane", "333222111", "maryJ@yahoo.com", "Jane's Emporium");
        contact1 = new Contact("Peter Parker", "999888777", "peterP@yahoo.com", "Webs");
        opportunity = new Opportunity(Product.FLATBED, 25, contact);
        standardIn = System.in;
    }

    @AfterEach
    public void tearDown() {
        System.setIn(standardIn);
    }

    @Test
    @DisplayName("Test: setId(). Id incremented as expected.")
    public void Opportunity_SetId_IdIncremented() {
        assertEquals(1001, opportunity.getId());
        opportunity1 = new Opportunity(Product.HYBRID, 200, contact1);
        assertEquals(1002, opportunity1.getId());
    }

    @Test
    @DisplayName("Test: setProduct(). Product set as expected.")
    public void Opportunity_SetProduct_ProductSet(){
        opportunity.setProduct(Product.BOX);
        assertEquals(Product.BOX, opportunity.getProduct());
    }

    @Test
    @DisplayName("Test: setQuantity(). Quantity set as expected.")
    public void Opportunity_SetQuantity_QuantitySet(){
        opportunity.setQuantity(111);
        assertEquals(111, opportunity.getQuantity());
    }

    @Test
    @DisplayName("Test: setStatus(). Status set as expected.")
    public void Opportunity_SetStatus_StatusSet(){
        opportunity.setStatus(Status.CLOSED_LOST);
        assertEquals(Status.CLOSED_LOST, opportunity.getStatus());
    }

    @Test
    @DisplayName("Test: setStatus(). Status not set as invalid input provided.")
    public void Opportunity_SetStatus_StatusNotSet(){
        opportunity.setStatus(Status.OPEN);
        assertFalse(opportunity.getStatus() == Status.OPEN);
    }

    @Test
    @DisplayName("Test: setInteger(). Integer attributes set as expected.")
    public void Opportunity_SetInteger_IntegerSet(){
        InputStream in = new ByteArrayInputStream("56".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        opportunity.setInteger(sc);
        assertEquals(opportunity.getQuantity(), 56);
    }

    @Test
    @DisplayName("Test: setInteger(). Integer attributes not set as invalid input provided.")
    public void Opportunity_SetInteger_IntegerNotSet(){
        InputStream in = new ByteArrayInputStream("0".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);

        in = new ByteArrayInputStream("400".getBytes());
        System.setIn(in);
        assertThrows(NullPointerException.class, () ->  opportunity.setInteger(sc));
    }

    @Test
    @DisplayName("Test: setEnum(). Enum attributes set as expected.")
    public void Opportunity_SetEnum_EnumSet(){
        InputStream in = new ByteArrayInputStream("flatBed".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        opportunity.setEnum(sc);
        assertEquals(opportunity.getProduct(), Product.FLATBED);
    }

    @Test
    @DisplayName("Test: setEnum(). Enum attributes not set as invalid input provided.")
    public void Opportunity_SetEnum_EnumNotSet(){
        InputStream in = new ByteArrayInputStream("arts".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        assertThrows(NullPointerException.class, () ->  opportunity.setEnum(sc));
    }

}
