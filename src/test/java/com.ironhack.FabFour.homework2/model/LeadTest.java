package com.ironhack.FabFour.homework2.model;

import com.ironhack.FabFour.homework2.model.Lead;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeadTest {

    public static Lead testLead = null;
    public static Lead testLeadTwo = null;

    @BeforeAll
    public static void setUp() {
        testLead = new Lead("Marie","01234 5678","marie@email.com","A New Company");
    }

    @Test
    @DisplayName("Test: Lead Constructor. Validate Correct ID Set.")
    public void LeadClass_LeadConstructor_CheckCorrectID() {
        long currentID = Lead.getLeadIDCount();
        testLeadTwo = new Lead("Rick","0208","rick@westley","Zombies");
        long updatedID = Lead.getLeadIDCount();
        assertTrue(updatedID == currentID + 1);
    }

    @Test
    @DisplayName("Test: Lead Constructor. Validate Correct Contact Name Set.")
    public void LeadClass_LeadConstructor_CheckCorrectName() {
        assertEquals("Marie", testLead.getContactName());
    }

    @Test
    @DisplayName("Test: Lead Constructor. Validate Correct Phone Number Set.")
    public void LeadClass_LeadConstructor_CheckCorrectPhoneNumber() {
        assertEquals("01234 5678", testLead.getPhoneNumber());
    }

    @Test
    @DisplayName("Test: Lead Constructor. Validate Correct Email Set.")
    public void LeadClass_LeadConstructor_CheckCorrectEmail() {
        assertEquals("marie@email.com", testLead.getEmail());
        assertEquals("A New Company", testLead.getCompanyName());
    }

    @Test
    @DisplayName("Test: Lead Constructor. Validate Correct Company Name Set.")
    public void LeadClass_LeadConstructor_CheckCorrectCompanyName() {
        assertEquals("A New Company", testLead.getCompanyName());
    }

    @Test
    @DisplayName("Test: toString(). Positive Test.")
    public void LeadClass_ToStringTest_ValidateString() {
        testLeadTwo = new Lead("Caddie", "1234 5678", "caddie@test.com","A Third Company");
        String testString = "Lead: " + testLeadTwo.getId() + ", Name of Contact: " + testLeadTwo.getContactName() + ", Phone Number: " +
                testLeadTwo.getPhoneNumber() + ", Email: " + testLeadTwo.getEmail() + ", Company Name: " + testLeadTwo.getCompanyName();
        assertTrue(testString.equals(testLeadTwo.toString()));
    }

    @Test
    @DisplayName(("Test: equals(). Negative Test."))
    public void LeadClass_EqualsTest_NegativeTest() {
        testLeadTwo = new Lead("Rick","0208","rick@westley","Zombies");
        assertFalse(testLeadTwo.equals(testLead));
    }

    @Test
    @DisplayName(("Test: equals(). Positive Test."))
    public void LeadClass_EqualsTest_PositiveTest() {
        long testId = testLead.getId();
        testLeadTwo = new Lead("Marie","01234 5678","marie@email.com","A New Company");
        testLeadTwo.id = testId;
        assertTrue(testLeadTwo.equals(testLead));
    }
}
