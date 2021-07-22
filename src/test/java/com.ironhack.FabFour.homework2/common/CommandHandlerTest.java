package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.model.Lead;
import com.ironhack.FabFour.homework2.model.LeadList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandHandlerTest {

    public CommandHandler test;
    Lead tempLeadOne = null;

    @BeforeEach
    public void setUp() {
        test = new CommandHandler();
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
}
