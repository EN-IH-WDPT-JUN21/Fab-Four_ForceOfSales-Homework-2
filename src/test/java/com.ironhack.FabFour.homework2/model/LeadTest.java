package com.ironhack.FabFour.homework2.model;

import com.ironhack.FabFour.homework2.model.Lead;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class LeadTest {

    public static Lead testLead = null;
    public static Lead testLeadTwo = null;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        testLead = new Lead("Marie","012345678","marie@email.com","A New Company");
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("Test: Lead Constructor. Validate Correct ID Set.")
    public void LeadClass_LeadConstructor_CheckCorrectID() {
        long currentID = Lead.getLeadIDCount();
        testLeadTwo = new Lead("Rick","012345678","rick@westley.com","Zombies");
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
        assertEquals("012345678", testLead.getPhoneNumber());
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
    @DisplayName("Test: setPhoneNumber(). Message shown when incorrect value provided")
    public void LeadClass_SetPhoneNumberTest_IncorrectValueProvided() {
        String simulatedInput = "123456789";
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        testLead.setPhoneNumber("0101");
        System.setIn(savedStandardInputStream);
        assertEquals("123456789",testLead.getPhoneNumber());
    }

    @Test
    @DisplayName("Test: setEmail(). Message shown when incorrect value provided")
    public void LeadClass_SetEmailTest_IncorrectValueProvided() {
        String simulatedInput = "test@buzz.com";
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        testLead.setEmail("0101");
        System.setIn(savedStandardInputStream);
        assertEquals("test@buzz.com",testLead.getEmail());
    }

    @Test
    @DisplayName("Test: setCompanyName(). Message shown when incorrect value provided")
    public void LeadClass_SetCompanyNameTest_IncorrectValueProvided() {
        String simulatedInput = "A Company Name";
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        testLead.setCompanyName("");
        System.setIn(savedStandardInputStream);
        assertEquals("A Company Name",testLead.getCompanyName());
    }

    @Test
    @DisplayName("Test: toString(). Positive Test.")
    public void LeadClass_ToStringTest_ValidateString() {
        testLeadTwo = new Lead("Caddie", "012345678", "caddie@test.com","A Third Company");
        String testString = "Lead: " + testLeadTwo.getId() + ", Contact: " + testLeadTwo.getContactName() + ", Phone Number: " +
                testLeadTwo.getPhoneNumber() + ", Email: " + testLeadTwo.getEmail() + ", Company Name: " + testLeadTwo.getCompanyName();
        assertTrue(testString.equals(testLeadTwo.toString()));
    }

    @Test
    @DisplayName(("Test: equals(). Negative Test."))
    public void LeadClass_EqualsTest_NegativeTest() {
        testLeadTwo = new Lead("Rick","012345678","rick@westley.com","Zombies");
        assertFalse(testLeadTwo.equals(testLead));
    }

    @Test
    @DisplayName(("Test: equals(). Positive Test."))
    public void LeadClass_EqualsTest_PositiveTest() {
        long testId = testLead.getId();
        testLeadTwo = new Lead("Marie","012345678","marie@email.com","A New Company");
        testLeadTwo.id = testId;
        assertTrue(testLeadTwo.equals(testLead));
    }
}
