package com.ironhack.FabFour.homework2.model;

import com.ironhack.FabFour.homework2.enums.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.*;

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
        long idBeforeIncrement = opportunity.getId();
        opportunity1 = new Opportunity(Product.HYBRID, 200, contact1);
        assertEquals(++idBeforeIncrement, opportunity1.getId());
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
        opportunity.setStatus(Status.CLOSED_WON);
        opportunity.setStatus(Status.OPEN);
        assertFalse(opportunity.getStatus() == Status.OPEN);
    }

    @Test
    @DisplayName("Test: equals(). Two Opportunity objects are equal as expected.")
    public void Opportunity_equals_areEqual(){
        opportunity = new Opportunity(Product.FLATBED, 25, contact);
        Opportunity equalOpportunity = new Opportunity(Product.FLATBED, 25, contact);
        assertTrue(opportunity.equals(opportunity));
        assertTrue(opportunity.equals(equalOpportunity));
    }

    @Test
    @DisplayName("Test: getDecisionMaker(). DecisionMaker object is an instance of Contact class as expected.")
    public void Opportunity_getDecisionMaker_isContactInstance(){
        assertTrue(opportunity.getDecisionMaker() instanceof Contact);
    }

    @Test
    @DisplayName("Test: toString(). Positive Test")
    public void Opportunity_ToStringTest_ValidateString() {
        String testString = "Opportunity: " + opportunity.getId() + ", Product: " + opportunity.getProduct() + ", Quantity: " +
                opportunity.getQuantity() + ", Contact: " + opportunity.getDecisionMaker().getContactName() + ", Status: " + opportunity.getStatus();
        assertTrue(testString.equals(opportunity.toString()));
    }
}
