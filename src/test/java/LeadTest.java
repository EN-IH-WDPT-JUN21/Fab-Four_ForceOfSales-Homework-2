import com.ironhack.FabFour.homework2.common.Lead;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeadTest {

    public static Lead completeLeadOne = null;
    public static Lead completeLeadTwo = null;
    public static Lead completeLeadThree = null;

    @BeforeAll
    public static void setUp() {
        completeLeadOne = new Lead("Marie","0000 1234","marie@email.com","A New Company");
        completeLeadTwo = new Lead("Barry", "1234 5678", "barry@test.com","Another Company");
    }

    @Test
    @DisplayName("Test: Complete Lead Constructor. Validate Values")
    public void LeadClass_CompleteLeadConstructor_CheckCorrectValues() {
        assertEquals(1,completeLeadOne.getId());
        assertEquals("Marie",completeLeadOne.getContactName());
        assertEquals("0000 1234",completeLeadOne.getPhoneNumber());
        assertEquals("marie@email.com",completeLeadOne.getEmail());
        assertEquals("A New Company",completeLeadOne.getCompanyName());

        assertEquals(2,completeLeadTwo.getId());
        assertEquals("Barry",completeLeadTwo.getContactName());
        assertEquals("1234 5678",completeLeadTwo.getPhoneNumber());
        assertEquals("barry@test.com",completeLeadTwo.getEmail());
        assertEquals("Another Company",completeLeadTwo.getCompanyName());
    }

    @Test
    @DisplayName("Test: LeadCountID. Validate Count Incremented")
    public void LeadClass_LeadCountID_ValidateCountIncrement() {
        assertEquals(2,Lead.getLeadIDCount()-1);
        completeLeadThree = new Lead("Caddie", "1234 5678", "caddie@test.com","A Third Company");
        assertEquals(3,Lead.getLeadIDCount()-1);
    }

}
