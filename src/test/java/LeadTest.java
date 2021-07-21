import com.ironhack.FabFour.homework2.common.Lead;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class LeadTest {

    public static Lead testLead = null;
    public static Lead testLeadTwo = null;

    @BeforeAll
    public static void setUp() {
        testLead = new Lead("Marie","0000 1234","marie@email.com","A New Company");
    }

    @Test
    @DisplayName("Test: Lead Constructor. Validate ID Set.")
    public void LeadClass_LeadConstructor_CheckCorrectID() {
        assertEquals(1, testLead.getId());
    }

    @Test
    @DisplayName("Test: Lead Constructor. Validate Contact Name Set.")
    public void LeadClass_LeadConstructor_CheckCorrectName() {
        assertEquals("Marie", testLead.getContactName());
    }

    @Test
    @DisplayName("Test: Lead Constructor. Validate Phone Number Set.")
    public void LeadClass_LeadConstructor_CheckCorrectPhoneNumber() {
        assertEquals("0000 1234", testLead.getPhoneNumber());
    }

    @Test
    @DisplayName("Test: Lead Constructor. Validate Email Set.")
    public void LeadClass_LeadConstructor_CheckCorrectEmail() {
        assertEquals("marie@email.com", testLead.getEmail());
        assertEquals("A New Company", testLead.getCompanyName());
    }

    @Test
    @DisplayName("Test: Lead Constructor. Validate Company Name Set.")
    public void LeadClass_LeadConstructor_CheckCorrectCompanyName() {
        assertEquals("A New Company", testLead.getCompanyName());
    }

    @Test
    @DisplayName("Test: LeadCountID. Validate Count Incremented")
    public void LeadClass_LeadCountID_ValidateCountIncrement() {
        var currentLeadCount = Lead.getLeadIDCount();
        testLeadTwo = new Lead("Caddie", "1234 5678", "caddie@test.com","A Third Company");
        var updatedLeadCount = Lead.getLeadIDCount();
        assertTrue(currentLeadCount == (updatedLeadCount - 1));
    }

}
