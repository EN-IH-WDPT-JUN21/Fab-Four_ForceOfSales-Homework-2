package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.enums.Status;
import com.ironhack.FabFour.homework2.model.Account;
import com.ironhack.FabFour.homework2.model.Contact;
import com.ironhack.FabFour.homework2.model.Lead;
import com.ironhack.FabFour.homework2.model.Opportunity;
import static org.junit.jupiter.api.Assertions.*;
import com.ironhack.FabFour.homework2.model.Lead;
import com.ironhack.FabFour.homework2.model.LeadList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CommandHandlerTest {

    public CommandHandler test;
    Lead tempLeadOne = null;
    Account newAccount;
    Opportunity newOpportunity;

    @BeforeEach
    public void setUp() {
        test = new CommandHandler();
        //newAccount = cm.convertLead(12);
        newOpportunity = newAccount.getOpportunityList().get(0);
    }

//    @Test
//    @DisplayName("Test: createLead(). Validate that newly created lead is added to LeadList.")
//    public void CommandHandler_CreateLeadTest_ValidateLeadAddedToList() {
//        var currentListSize = LeadList.getListOfLeads().size();
////        test.createLead();
//        assertTrue(LeadList.getListOfLeads().size() == currentListSize + 1);
//    }

    @Test
    @DisplayName("Test: lookupLead(). Return the lead as expected.")
    public void CommandHandler_LookupLead_LeadReturned() {
        tempLeadOne = new Lead("Buzz","0800","buzz@lightyear","Toy Story");
        LeadList.getListOfLeads().add(tempLeadOne);
        long tempID = tempLeadOne.getId();
        Lead tempLeadTwo = test.lookupLead(tempID);
        assertTrue(tempID == tempLeadTwo.getId());
    }

    @Test
    @DisplayName("Test: lookupLead(). Do not return the lead, as not in list.")
    public void CommandHandler_LookupLead_LeadNotReturned() {
        Lead tempLead = test.lookupLead(99);
        assertNull(tempLead);
    }

    @Test
    @DisplayName("Test: removeLead(). Remove the lead as expected.")
    public void CommandHandler_RemoveLead_LeadRemoved() {
        tempLeadOne = new Lead("Buzz","0800","buzz@lightyear","Toy Story");
        LeadList.getListOfLeads().add(tempLeadOne);
        int currentListSize = LeadList.getListOfLeads().size();
        test.removeLead(1);
        int updatedListSize = LeadList.getListOfLeads().size();
        assertTrue(currentListSize == updatedListSize + 1);
    }

    @Test
    @DisplayName("Test: removeLead(). Do not remove lead, as ID doesn't exist.")
    public void CommandHandler_RemoveLead_LeadNotRemoved() {
        int currentListSize = LeadList.getListOfLeads().size();
        test.removeLead(99);
        int updatedListSize = LeadList.getListOfLeads().size();
        assertTrue(currentListSize == updatedListSize);
    }
  //test contact creation
//test contact info = Lead info
//test user input?
//test opp creation
//test opp info from input
//test opp decisionMaker = Contact
//test opp status = OPEN
//test account creation

    @Test
    public void createContactTest(){}//count Contact objects?

    /*
    @Test
    public void contactInfoTest(){
        Contact newDecisionMaker = newOpportunity.getDecisionMaker();
        assertFalse(newDecisionMaker.getId(), newLead.getId());
        assertEquals(newDecisionMaker.getContactName(), newLead.getContactName());
        assertEquals(newDecisionMaker.getPhoneNumber(), newLead.getPhoneNumber());
        assertEquals(newDecisionMaker.getEmail(), newLead.getEmail());
        assertEquals(newDecisionMaker.getCompanyName(), newLead.getCompanyName());
    }

     */


    @Test
    public void opportunityInfoTest(){}//same as user input

    /*
    @Test
    public void setDecisionMakerTest(){
        assertTrue(newOpportunity.getDecisionMaker() instanceof Contact);
        assertEquals(newOpportunity.getDecisionMaker().getEmail() instanceof String);
    }//is a Contact object with correct data

     */

    @Test
    public void setOpenStatusTest(){
        assertEquals(newOpportunity.getStatus(), Status.OPEN);
    }

    @Test
    public void createOpportunityTest(){}//count opportunities + check type

}
