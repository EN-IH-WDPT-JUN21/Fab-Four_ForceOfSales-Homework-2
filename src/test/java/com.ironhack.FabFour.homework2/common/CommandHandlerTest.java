package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.enums.Status;
import com.ironhack.FabFour.homework2.model.Account;
import com.ironhack.FabFour.homework2.model.Contact;
import com.ironhack.FabFour.homework2.model.Lead;
import com.ironhack.FabFour.homework2.model.Opportunity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


//test contact creation
//test contact info = Lead info
//test user input?
//test opp creation
//test opp info from input
//test opp decisionMaker = Contact
//test opp status = OPEN
//test account creation
public class CommandHandlerTest {
    CommandHandler cm;
    Lead newLead;
    Account newAccount;
    Opportunity newOpportunity;
    @BeforeEach
    public void setUp(){
        cm = new CommandHandler();
        newLead  = new Lead(12, "Mark Twain", "333111222", "markt@yahoo.com", "Blackness");
        newAccount = cm.convertLead(12);
        newOpportunity = newAccount.getOpportunityList().get(0);
    }

    @Test
    public void createContactTest(){}//count Contact objects?

    @Test
    public void contactInfoTest(){
        Contact newDecisionMaker = newOpportunity.getDecisionMaker();
        assertFalse(newDecisionMaker.getId(), newLead.getId());
        assertEquals(newDecisionMaker.getContactName(), newLead.getContactName());
        assertEquals(newDecisionMaker.getPhoneNumber(), newLead.getPhoneNumber());
        assertEquals(newDecisionMaker.getEmail(), newLead.getEmail());
        assertEquals(newDecisionMaker.getCompanyName(), newLead.getCompanyName());
    }

    @Test
    public void opportunityInfoTest(){}//same as user input

    @Test
    public void setDecisionMakerTest(){
        assertTrue(newOpportunity.getDecisionMaker() instanceof Contact);
        assertEquals(newOpportunity.getDecisionMaker().getEmail() instanceof String);
    }//is a Contact object with correct data

    @Test
    public void setOpenStatusTest(){
        assertEquals(newOpportunity.getStatus(), Status.OPEN);
    }

    @Test
    public void createOpportunityTest(){}//count opportunities + check type
    
}
